package com.example.shaadicomandroidassesment.data

import com.google.gson.annotations.SerializedName

data class ShaadiResponse(@SerializedName("results")val mShaadiList: MutableList<ShaadiData>) {

}