package com.example.shaadicomandroidassesment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.shaadicomandroidassesment.base.BaseViewModel
import com.example.shaadicomandroidassesment.data.ShaadiData
import com.example.shaadicomandroidassesment.data.ShaadiId
import com.example.shaadicomandroidassesment.data.UserSelected
import com.example.shaadicomandroidassesment.database.ShaadiDatabase
import com.example.shaadicomandroidassesment.repository.ShaadiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ShaadiViewModel(private val repository: ShaadiRepository,private val database:ShaadiDatabase) :BaseViewModel() {
    val users = MutableLiveData<List<ShaadiData>>()
    val userSelected = MutableLiveData<List<UserSelected>>()
    fun getShaadiData() {
        viewModelScope.launch {

            withContext(Dispatchers.IO) {
                repository.saveShaadiDataIntoStorage()

            }
            withContext(Dispatchers.Main) {
                users.value = database.getShaadiDao.findAll()
            }
        }
    }

    fun postIsUserSelected(shaadiId: ShaadiId, isSelected: Boolean) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                database.getSelectedDao.add(
                    UserSelected(
                        0,
                        shaadiId.name,
                        shaadiId.value,
                        isSelected
                    )
                )
            }
        }
    }

    fun getUserSelectedList() {
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                userSelected.value=database.getSelectedDao.findAll()
            }

        }

    }
}