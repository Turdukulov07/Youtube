package com.example.kotlinlesson4.remote

import com.example.kotlinlesson4.model.DetailsPlaylist
import com.example.kotlinlesson4.model.PlayList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApi {
    @GET("playlists")
    suspend fun fetchAllPlayList(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") apiKey: String,
        @Query("maxResults") maxResults: Int,
    ): Response<PlayList>

    @GET("playlistItems")
    suspend fun fetchDetailsPlaylist(
        @Query("part") part: String,
        @Query("playlistId") playlistId: String,
        @Query("key") apiKey: String,
    ): Response<DetailsPlaylist>



}