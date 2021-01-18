package com.example.shaadicomandroidassesment.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shaadicomandroidassesment.data.ShaadiData
import com.example.shaadicomandroidassesment.data.UserSelected

@Dao
interface UserSelectedDao {

    @Query("SELECT * FROM userselected")
    fun findAll(): List<UserSelected>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(users: UserSelected)
}