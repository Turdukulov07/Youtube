package com.example.kotlinlesson4.remote

import com.example.kotlinlesson4.`object`.Constant
import com.example.kotlinlesson4.core.network.BaseDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    factory { RemoteDataSource(get()) }
}

class RemoteDataSource(private val apiService: YoutubeApi) : BaseDataSource() {


    suspend fun fetchAllPlaylist() = getResult {
        apiService.fetchAllPlayList(
            Constant.PART,
            Constant.CHANNEL_ID,
            Constant.API_KEY,
            Constant.MAX_RESULTS
        )
    }

    suspend fun fetchDetailsPlaylist(id: String) = getResult {
        apiService.fetchDetailsPlaylist(Constant.PART, id, Constant.API_KEY)
    }
}