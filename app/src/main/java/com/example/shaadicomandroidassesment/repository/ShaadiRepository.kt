package com.example.shaadicomandroidassesment.repository

import com.example.shaadicomandroidassesment.data.ShaadiData
import com.example.shaadicomandroidassesment.database.ShaadiDatabase
import com.example.shaadicomandroidassesment.service.ShaadiApiService

class ShaadiRepository(private val service: ShaadiApiService,private val database: ShaadiDatabase) {

    private suspend fun getData() = service.getShaadiResponse().await()


    suspend fun saveShaadiDataIntoStorage(): List<ShaadiData> {
     //   if (offset.isEmpty()) return listOf()
        try {
            val users = mutableListOf<ShaadiData>()
            val request = getData()
            users.addAll(request.mShaadiList)
            users.forEach{
                database.getShaadiDao.add(it)
            }
            return database.getShaadiDao.findAll()
        }catch (exception:Exception){
           if(database.getShaadiDao.findAll().size>0){
               return database.getShaadiDao.findAll()
           }else{
               return listOf()
           }

        }

    }
}