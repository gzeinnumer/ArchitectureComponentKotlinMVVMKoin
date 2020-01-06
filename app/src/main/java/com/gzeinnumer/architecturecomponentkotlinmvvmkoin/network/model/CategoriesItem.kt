package com.gzeinnumer.architecturecomponentkotlinmvvmkoin.network.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "CategoriesItem")
data class CategoriesItem(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @field:SerializedName("idCategory")
    val idCategory: String? = null,

    @field:SerializedName("strCategory")
    val strCategory: String? = null,

    @field:SerializedName("strCategoryDescription")
    val strCategoryDescription: String? = null,

    @field:SerializedName("strCategoryThumb")
    val strCategoryThumb: String? = null
)