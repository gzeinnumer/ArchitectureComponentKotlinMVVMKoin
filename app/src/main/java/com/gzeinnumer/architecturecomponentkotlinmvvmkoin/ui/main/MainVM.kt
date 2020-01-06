package com.gzeinnumer.architecturecomponentkotlinmvvmkoin.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.data.local.MyDatabase
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.data.model.Phrase

class MainVM (private val database: MyDatabase) : ViewModel() {

    private val data = MutableLiveData<List<Phrase>>()


    fun getAllPhrases(): LiveData<List<Phrase>> = data

    fun loadAllData(){
        //TODO: load data

    }

    fun savePhrase(phrase: Phrase){

    }

}