package com.example.kotlinlesson4.di

import com.example.kotlinlesson4.core.network.networkModule
import com.example.kotlinlesson4.local.prefsModule
import com.example.kotlinlesson4.remote.remoteDataSourceModule

val koinModules = listOf(
    networkModule,
    remoteDataSourceModule,
    repoModules,
    viewModules,
    prefsModule
)