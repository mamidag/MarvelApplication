package com.example.marvelcharacters.api

import com.example.marvelcharacters.api.model.Marvel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {

    @GET("v1/public/characters")
    suspend fun getCharacters(
        @Query("ts") timestamp: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Marvel

    @GET("v1/public/characters/{characterId}")
    suspend fun getCharactersDetail(
        @Path("characterId") characterId: Int,
        @Query("ts") timestamp: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String,
    ): Marvel


    ///comics?format=comic&dateRange=2005-01-01%2C2020-01-01&orderBy=-onsaleDate&limit=100&apikey=996d1c8c10a435af5a74f2efaeefdae7

    @GET("v1/public/characters/{characterId}/comics")
    suspend fun getCharactersComics(
        @Path("characterId") characterId: Int,
        @Query("ts") timestamp:String,
        @Query("apikey") apikey:String,
        @Query("hash") hash:String,
        @Query("dateRange") dateRange: String,
        @Query("orderBy") orderBy: String,
        @Query("limit") limit: Int
    ): Marvel


}