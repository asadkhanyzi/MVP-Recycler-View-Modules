package com.lepaya.test.di

import com.lepaya.data.api.Api
import com.lepaya.data.network.createApi
import com.lepaya.data.network.createConverterFactory
import com.lepaya.data.network.createGson
import com.lepaya.data.network.createHttpClient
import com.lepaya.data.repositories.TrainerRepositoryImpl
import com.lepaya.domain.interactors.TrainerInteractor
import com.lepaya.test.BuildConfig
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoriesModule: Module = module {
    single { TrainerRepositoryImpl(api = get()) }

}

val interactorsModule: Module = module {
    single {
        TrainerInteractor(
            trainerRepository = get() as TrainerRepositoryImpl
        )
    }
}

val networkModule: Module = module {
    single {
        createApi<Api>(
            baseUrl = BuildConfig.BASE_API_URL,
            okHttpClient = get(),
            converterFactory = get()
        )
    }

    factory { createHttpClient() }
    factory { createConverterFactory(gson = get()) }
    factory { createGson() }
}