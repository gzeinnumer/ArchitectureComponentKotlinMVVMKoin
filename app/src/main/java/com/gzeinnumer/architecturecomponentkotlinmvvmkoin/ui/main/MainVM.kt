package com.gzeinnumer.architecturecomponentkotlinmvvmkoin.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.koin.MainRepository
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.network.handling.Resource
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.network.model.MyResponse
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class MainVM (private val mainRepository: MainRepository) : ViewModel() {

    fun getCategory(): LiveData<Resource<MyResponse>> {
        val list = MutableLiveData<Resource<MyResponse>>()

        mainRepository.getCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .doOnSubscribe {
                list.value = Resource.showLoading(null)
            }
            .doFinally {
//                list.value = Resource.hideLoading(null)
            }
            .subscribeBy(
                onSuccess = {
                    list.postValue(Resource.success(it))
                },

                onError = {
                    list.postValue(Resource.error(it.message.toString(), null))
                }
            )

        Log.d("MyZein", mainRepository.getDb().categoriesDao().getAll().size.toString())

        return list
    }

}