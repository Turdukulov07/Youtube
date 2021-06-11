package com.example.kotlinlesson4.core.network.result

data class Resource<out T>(val status: Status, val data: T?, val message: String?, val code: Int?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null, null)
        }

        fun <T> error(msg: String?, data: T? = null, code: Int? = null): Resource<T> {
            return Resource(Status.ERROR, data, msg, code)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null, null)
        }
    }
}


