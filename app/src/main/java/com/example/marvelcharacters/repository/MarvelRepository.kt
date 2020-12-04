package com.example.marvelcharacters.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingSource
import com.example.marvelcharacters.api.MarvelApi
import com.example.marvelcharacters.api.model.Marvel
import com.example.marvelcharacters.api.model.data.result.Result
import com.example.marvelcharacters.dataresource.Resource
import com.example.marvelcharacters.util.MarvelHashGenerate
import com.example.marvelcharacters.util.keys.ApiKeys
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
@ExperimentalCoroutinesApi
class MarvelRepository @Inject constructor(
    private val marvelApi: MarvelApi
):PagingSource<Int,Result>() {
    val timeStamp = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())


    override suspend fun load(params: PagingSource.LoadParams<Int>): PagingSource.LoadResult<Int, Result> {
        try {
            // Start refresh at offset 1 if undefined.
            val nextPage = params.key ?: 0
            val resultList: MutableLiveData<Marvel> = MutableLiveData()
            val character = flow {
                emit(Resource.loading(null))
                val items = marvelApi.getCharacters(
                    timestamp = timeStamp.toString(),
                    apikey = ApiKeys.publicKey,
                    hash = MarvelHashGenerate.generate(
                        timeStamp,
                        ApiKeys.privateKey,
                        ApiKeys.publicKey
                    ),
                    limit = 30,
                    offset = nextPage
                )
                emit(Resource.success(items))
            }.catch {
                emit(Resource.error(it.localizedMessage, null, it))
            }
            character.collect {
                resultList.value = it.data
            }
            return PagingSource.LoadResult.Page(
                data = resultList.value!!.data.results,
                prevKey = if (nextPage == 30) null else nextPage - 30,
                nextKey = resultList.value!!.data.offset!! + 30
            )
        } catch (e: Exception) {
            return PagingSource.LoadResult.Error(e)
        }
    }

}