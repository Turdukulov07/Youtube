package com.example.kotlinlesson4.ui.details

import androidx.lifecycle.MutableLiveData
import com.example.kotlinlesson4.core.network.result.Status
import com.example.kotlinlesson4.core.ui.BaseViewModel
import com.example.kotlinlesson4.model.DetailsPlaylist
import com.example.kotlinlesson4.repository.Repository

class DetailsViewModel(private val repository: Repository) : BaseViewModel() {

    val detailsPlaylistLiveData = MutableLiveData<DetailsPlaylist>()
    val isProgress = MutableLiveData<Boolean>()

    fun fetchDetailsPlaylist(id: String) {
        repository.fetchDetailsPlaylist(id).observeForever { resource ->
            when (resource.status) {
                Status.LOADING -> {
                    isProgress.value = true
                }
                Status.ERROR -> {
                    isProgress.value = false

                }
                Status.SUCCESS -> {
                    isProgress.value = false
                    resource.data?.let {
                        detailsPlaylistLiveData.value = it
                    }
                }
            }
        }
    }
}