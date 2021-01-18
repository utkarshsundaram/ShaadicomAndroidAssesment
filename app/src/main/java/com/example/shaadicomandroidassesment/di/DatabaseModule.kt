package com.example.shaadicomandroidassesment.di

import android.app.Application
import androidx.room.Room
import com.example.shaadicomandroidassesment.database.ShaadiDao
import com.example.shaadicomandroidassesment.database.ShaadiDatabase
import com.example.shaadicomandroidassesment.database.UserSelectedDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideDatabase(application: Application): ShaadiDatabase {
        return Room.databaseBuilder(application, ShaadiDatabase::class.java, "shaadi_profile")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun provideShaadiDao(database: ShaadiDatabase): ShaadiDao {
        return  database.getShaadiDao
    }

    fun provideUserSelectedDao(database: ShaadiDatabase):UserSelectedDao{
        return database.getSelectedDao
    }
    single { provideDatabase(androidApplication()) }
    single { provideShaadiDao(get()) }
    single { provideUserSelectedDao(get()) }
}