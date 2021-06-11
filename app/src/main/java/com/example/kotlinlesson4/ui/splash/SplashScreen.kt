package com.example.kotlinlesson4.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinlesson4.R
import com.example.kotlinlesson4.ui.main.MainActivity


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.splashScreenTheme)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}