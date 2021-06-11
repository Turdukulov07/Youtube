package com.example.kotlinlesson4.di

import com.example.kotlinlesson4.ui.details.DetailsViewModel
import com.example.kotlinlesson4.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModules: Module = module {
    viewModel { MainViewModel(get()) }
    viewModel { DetailsViewModel(get()) }
}