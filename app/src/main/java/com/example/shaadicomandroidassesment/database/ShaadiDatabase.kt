package com.example.shaadicomandroidassesment.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.shaadicomandroidassesment.data.ShaadiData
import com.example.shaadicomandroidassesment.data.UserSelected
import com.example.shaadicomandroidassesment.utils.ShaadiTypeConverters

@Database(entities = [ShaadiData::class,UserSelected::class], version = 2, exportSchema = false)
@TypeConverters(
    ShaadiTypeConverters::class
    )
abstract class ShaadiDatabase : RoomDatabase() {
    abstract val getShaadiDao: ShaadiDao
    abstract val getSelectedDao:UserSelectedDao
}
