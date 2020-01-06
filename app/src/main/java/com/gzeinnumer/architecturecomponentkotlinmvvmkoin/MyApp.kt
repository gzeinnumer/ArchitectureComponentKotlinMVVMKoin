package com.gzeinnumer.architecturecomponentkotlinmvvmkoin

import android.app.Application
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.koin.DependencyModules
import org.koin.android.ext.android.startKoin

class MyApp: Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(
                DependencyModules.appModules
        ) )
    }
}