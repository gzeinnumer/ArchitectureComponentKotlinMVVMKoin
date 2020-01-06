package com.gzeinnumer.architecturecomponentkotlinmvvmkoin.koin

import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.data.local.MyDatabase
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.network.ApiInterface
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.network.model.MyResponse
import io.reactivex.Single

class MainRepositoryImpl(private val apiInterface: ApiInterface, private val db: MyDatabase) : MainRepository {
    override fun getCategories(): Single<MyResponse> {
        return apiInterface.categories()
    }

    override fun getDb(): MyDatabase {
        return db
    }
}