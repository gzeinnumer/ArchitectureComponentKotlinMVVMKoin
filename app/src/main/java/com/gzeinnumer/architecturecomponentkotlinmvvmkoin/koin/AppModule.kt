package com.gzeinnumer.architecturecomponentkotlinmvvmkoin.koin

import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.data.local.MyDatabase
import com.gzeinnumer.architecturecomponentkotlinmvvmkoin.ui.main.MainVM
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


val appModules = module {

    factory { MyDatabase.getInstance(get()) }

    viewModel {
        MainVM(get())
        //MainVM2(get())
    }
}