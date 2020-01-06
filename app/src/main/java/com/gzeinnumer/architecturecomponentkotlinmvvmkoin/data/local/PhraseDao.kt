package com.gzeinnumer.architecturecomponentkotlinmvvmkoin.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.data.model.Phrase

@Dao
interface PhraseDao{

    @Insert
    fun insert(phrase: Phrase)

    @Query("SELECT * FROM phrases_table")
    fun getAll(): List<Phrase>

}