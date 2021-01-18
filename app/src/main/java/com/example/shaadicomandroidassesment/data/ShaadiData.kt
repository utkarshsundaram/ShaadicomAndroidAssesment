package com.example.shaadicomandroidassesment.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.shaadicomandroidassesment.utils.ShaadiTypeConverters

@Entity
data class ShaadiData(@PrimaryKey(autoGenerate = true) var mTableid: Int, val gender:String, @TypeConverters(ShaadiTypeConverters::class)val name: ShaadiName, @TypeConverters(ShaadiTypeConverters::class)val id:ShaadiId, @TypeConverters(ShaadiTypeConverters::class)val picture:ShaadiImage) {
}