package com.gzeinnumer.architecturecomponentkotlinmvvmkoin

import android.app.Application
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.koin.appModules
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.koin.networkModule
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.koin.repositoryModule
import org.koin.android.ext.android.startKoin

class MyApp: Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(
                appModules,
                networkModule,
                repositoryModule
        ) )
    }
}