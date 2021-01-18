package com.example.shaadicomandroidassesment.utils

import androidx.room.TypeConverter
import com.example.shaadicomandroidassesment.data.ShaadiId
import com.example.shaadicomandroidassesment.data.ShaadiImage
import com.example.shaadicomandroidassesment.data.ShaadiName
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ShaadiTypeConverters {

    @TypeConverter
    fun fromShaadiImage(stat: ShaadiImage): String {
        return Gson().toJson(stat)
    }

    /**
     * Convert a json to a list of Images
     */
    @TypeConverter
    fun toShaadiImage(jsonImages: String): ShaadiImage {
        val notesType = object : TypeToken<ShaadiImage>() {}.type
        return Gson().fromJson<ShaadiImage>(jsonImages, notesType)
    }




    @TypeConverter
    fun fromShaadiId(stat: ShaadiId): String {
        return Gson().toJson(stat)
    }

    /**
     * Convert a json to a list of Images
     */
    @TypeConverter
    fun toShaadiId(jsonImages: String): ShaadiId {
        val notesType = object : TypeToken<ShaadiId>() {}.type
        return Gson().fromJson<ShaadiId>(jsonImages, notesType)
    }


    @TypeConverter
    fun fromShaadiName(stat: ShaadiName): String {
        return Gson().toJson(stat)
    }

    /**
     * Convert a json to a list of Images
     */
    @TypeConverter
    fun toShadiName(jsonImages: String): ShaadiName {
        val notesType = object : TypeToken<ShaadiName>() {}.type
        return Gson().fromJson<ShaadiName>(jsonImages, notesType)
    }
}