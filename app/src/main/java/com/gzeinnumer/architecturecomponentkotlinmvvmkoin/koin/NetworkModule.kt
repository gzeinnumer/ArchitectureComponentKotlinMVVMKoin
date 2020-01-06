package com.gzeinnumer.architecturecomponentkotlinmvvmkoin.koin

import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.network.ApiInterface
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

//tipe 2
val networkModule = module {
    single {
        createWebService<ApiInterface>()
    }
}

inline fun <reified T> createWebService(): T {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.themealdb.com/api/json/v1/1/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
    return retrofit.create(T::class.java)
}