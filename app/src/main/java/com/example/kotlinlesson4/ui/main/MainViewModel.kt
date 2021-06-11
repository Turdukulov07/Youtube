package com.example.kotlinlesson4.ui.main

import androidx.lifecycle.MutableLiveData
import com.example.kotlinlesson4.core.network.result.Status
import com.example.kotlinlesson4.core.ui.BaseViewModel
import com.example.kotlinlesson4.model.PlayList
import com.example.kotlinlesson4.repository.Repository

class MainViewModel(private val repository: Repository) : BaseViewModel() {

    var loading = MutableLiveData<Boolean>()
    val mainPlaylistLiveData = MutableLiveData<PlayList>()


    fun fetchMainPlaylist() {
        repository.fetchYoutubeApiPlayList().observeForever { resource ->
            when (resource.status) {
                Status.LOADING -> {
                    loading.value = true
                }
                Status.ERROR -> {
                    loading.value = false

                }
                Status.SUCCESS -> {
                    loading.value = false
                    resource.data?.let {
                        mainPlaylistLiveData.value = it
                    }
                }
            }
        }
    }
}
