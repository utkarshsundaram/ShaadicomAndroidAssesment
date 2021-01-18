package com.example.shaadicomandroidassesment.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserSelected(@PrimaryKey(autoGenerate = true)val id:Int,val name:String,val value:String,val isSelected:Boolean) {
}