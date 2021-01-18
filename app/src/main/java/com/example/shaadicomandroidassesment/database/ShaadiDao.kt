package com.example.shaadicomandroidassesment.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shaadicomandroidassesment.data.ShaadiData

@Dao
interface ShaadiDao {

    @Query("SELECT * FROM shaadidata")
    fun findAll(): List<ShaadiData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(users: ShaadiData)
}