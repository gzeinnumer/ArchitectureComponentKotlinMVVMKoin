package com.gzeinnumer.architecturecomponentkotlinmvvmkoin.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.network.model.CategoriesItem

@Dao
interface CategoriesDao{

    @Insert
    fun insert(phrase: CategoriesItem)

    @Query("SELECT * FROM CategoriesItem")
    fun getAll(): List<CategoriesItem>

}