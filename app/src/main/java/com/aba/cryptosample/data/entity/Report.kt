package com.aba.cryptosample.data.entity


import androidx.room.Entity
import com.google.gson.annotations.SerializedName


@Entity(tableName = "reports" , primaryKeys = arrayOf("id"))
data class Report(
    @SerializedName("category")
    var category: String? = null ,
    @SerializedName("dateReleased")
    var dateReleased: String? = null ,
    @SerializedName("effectiveness")
    var effectiveness: Int? = null ,

    @SerializedName("_id")
    var id: String,
    @SerializedName("manufacturer")
    var manufacturer: String? = null ,
    @SerializedName("product")
    var product: String? = null ,
    @SerializedName("rating")
    var rating: Double? = null ,
    @SerializedName("__v")
    var v: Int? = null ,
    @SerializedName("videoCode")
    var videoCode: String? = null ,
    @SerializedName("videoTitle")
    var videoTitle: String? = null
)