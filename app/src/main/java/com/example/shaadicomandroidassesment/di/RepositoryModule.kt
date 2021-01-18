package com.example.shaadicomandroidassesment.di

import com.example.shaadicomandroidassesment.repository.ShaadiRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { ShaadiRepository(get(),get()) }
}