package com.omkar.mybbshopkotlin.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.HashMap

data class BBLoginResp (val status:String ,val data:HashMap<String,String>): Serializable {

}