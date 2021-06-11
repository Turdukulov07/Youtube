package com.example.kotlinlesson4.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.kotlinlesson4.core.network.result.Resource
import com.example.kotlinlesson4.model.DetailsPlaylist
import com.example.kotlinlesson4.model.PlayList
import com.example.kotlinlesson4.remote.RemoteDataSource
import kotlinx.coroutines.Dispatchers

class Repository(private val dataSource: RemoteDataSource) {

    fun fetchYoutubeApiPlayList(): LiveData<Resource<PlayList>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        val response = dataSource.fetchAllPlaylist()
        emit(response)
    }

    fun fetchDetailsPlaylist(id: String): LiveData<Resource<DetailsPlaylist>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading(null))
            val response = dataSource.fetchDetailsPlaylist(id)
            emit(response)
        }
}
