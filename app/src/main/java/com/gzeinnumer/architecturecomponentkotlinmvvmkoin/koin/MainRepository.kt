package com.gzeinnumer.architecturecomponentkotlinmvvmkoin.koin

import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.data.local.MyDatabase
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.network.model.MyResponse
import io.reactivex.Single

interface MainRepository {
    fun getCategories(): Single<MyResponse>
    fun getDb(): MyDatabase
}