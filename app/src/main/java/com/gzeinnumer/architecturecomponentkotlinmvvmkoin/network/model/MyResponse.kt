package com.gzeinnumer.architecturecomponentkotlinmvvmkoin.network.model

import com.google.gson.annotations.SerializedName

data class MyResponse(

	@field:SerializedName("categories")
	val categories: List<CategoriesItem>? = null
)