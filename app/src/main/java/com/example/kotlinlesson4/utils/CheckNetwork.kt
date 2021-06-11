package com.example.kotlinlesson4.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CheckNetwork(private val context: Context, private val listener: OnInternetDisconnected) :
    ConnectivityManager.NetworkCallback() {

    var cm: ConnectivityManager? = null


    fun checkInternet() {
        if (cm == null)
            cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val builder: NetworkRequest.Builder = NetworkRequest.Builder()
            cm?.registerNetworkCallback(
                builder.build(),
                this
            )
        }
    }

    fun unRegisterNetwork() {
        cm?.unregisterNetworkCallback(this)
    }

    override fun onAvailable(network: Network) {
        CoroutineScope(Dispatchers.IO).launch {

            val isWifi: Boolean = cm?.getNetworkCapabilities(network)!!.hasTransport(
                NetworkCapabilities.TRANSPORT_WIFI
            )

            doSomething(true, isWifi)
        }
    }

    override fun onLost(network: Network) {
        CoroutineScope(Dispatchers.IO).launch {
            doSomething(false)
        }
    }

    private suspend fun doSomething(isConnected: Boolean, isWifi: Boolean = false) {
        withContext(Dispatchers.Main) {
            if (isConnected) {
                listener.showMessage(true)

            } else {
                listener.showMessage(false)
            }
        }

    }
}

interface OnInternetDisconnected {
    fun showMessage(isConnected: Boolean) {}
}