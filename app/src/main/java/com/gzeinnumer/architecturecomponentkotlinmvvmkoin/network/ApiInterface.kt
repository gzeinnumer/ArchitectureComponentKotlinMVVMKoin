package com.gzeinnumer.architecturecomponentkotlinmvvmkoin.network

import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.network.model.MyResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {
    @GET("categories.php")
    fun categories(): Single<MyResponse>
}