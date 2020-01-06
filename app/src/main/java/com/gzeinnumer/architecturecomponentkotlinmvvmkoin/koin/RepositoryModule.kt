package com.gzeinnumer.architecturecomponentkotlinmvvmkoin.koin

import org.koin.dsl.module.module

val repositoryModule = module {
    single<MainRepository> { MainRepositoryImpl(get(),get()) }
}