package com.example.kotlinlesson4.core.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinlesson4.R
import com.example.kotlinlesson4.ui.InternetConnectionDialog
import com.example.kotlinlesson4.utils.CheckNetwork
import com.example.kotlinlesson4.utils.OnInternetDisconnected

abstract class BaseActivity(private val layout: Int) : AppCompatActivity(), OnInternetDisconnected {

    private var network = CheckNetwork(this, this)
    private var networkConnected = false
    private val dialog = InternetConnectionDialog.newInstance(this::onTryAgain)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_KotlinLesson4)
        setContentView(layout)
        setupUI()
        setupLiveData()

    }

    override fun showMessage(isConnected: Boolean) {
        networkConnected = isConnected
        if (isConnected) {
            Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show()
            setupLiveData()
        } else {
            Toast.makeText(this, "Disconnected", Toast.LENGTH_SHORT).show()
            dialog.show(supportFragmentManager, InternetConnectionDialog.TAG)


        }
    }

    private fun onTryAgain() {
        if (networkConnected) {
            dialog.dismiss()
        }
    }

    abstract fun setupUI()

    abstract fun setupLiveData()

    override fun onStop() {
        super.onStop()
        network.unRegisterNetwork()
    }

    override fun onResume() {
        super.onResume()
        network.checkInternet()
    }
}