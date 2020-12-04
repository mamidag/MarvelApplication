package com.example.marvelcharacters.repository

import com.example.marvelcharacters.api.MarvelApi
import com.example.marvelcharacters.api.model.Marvel
import com.example.marvelcharacters.api.params.dateRangeStart
import com.example.marvelcharacters.api.params.orderBy
import com.example.marvelcharacters.dataresource.Resource
import com.example.marvelcharacters.util.MarvelHashGenerate
import com.example.marvelcharacters.util.getDate
import com.example.marvelcharacters.util.keys.ApiKeys
import com.github.ajalt.timberkt.e
import com.github.ajalt.timberkt.i
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject


@ExperimentalCoroutinesApi
class CharactersRepository @Inject constructor(
    private val marvelApi: MarvelApi
) {
    val timeStamp = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())


    fun fetchCharacterDetail(characterId: Int): Flow<Resource<Marvel>> {
        return flow {
            emit(Resource.loading(null))
            val charactersDetail = marvelApi.getCharactersComics(
                characterId = characterId,
                timestamp = timeStamp.toString(),
                apikey = ApiKeys.publicKey,
                hash = MarvelHashGenerate.generate(
                    timeStamp,
                    ApiKeys.privateKey,
                    ApiKeys.publicKey
                ),
                dateRange = dateRangeStart + getDate(),
                orderBy = orderBy,
                limit = 10
            )
            emit(Resource.success(charactersDetail))
        }.retryWhen { cause, attempt ->
            i { "attempt count -> $attempt" }
            e { "cause -> $cause" }
            (cause is Exception).also { if (it) delay(10_000) }
        }.catch {
            emit(Resource.error(it.localizedMessage, null, it))
        }.flowOn(Dispatchers.IO)

    }

}