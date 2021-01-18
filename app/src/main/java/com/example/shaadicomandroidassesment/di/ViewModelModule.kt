package com.example.shaadicomandroidassesment.di

import com.example.shaadicomandroidassesment.viewmodel.ShaadiViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ShaadiViewModel(repository= get(),database = get()) }
}