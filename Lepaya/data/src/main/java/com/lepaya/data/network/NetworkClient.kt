package com.lepaya.data.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

fun createHttpClient(): OkHttpClient {
    val okHttpClientBuilder = OkHttpClient.Builder()
    with(okHttpClientBuilder) {

    }
    return okHttpClientBuilder.build()
}

fun createConverterFactory(gson: Gson): Converter.Factory {
    return GsonConverterFactory.create(gson)
}

fun createGson(): Gson {
    return GsonBuilder()
        .setLenient()
        .create()
}

inline fun <reified T> createApi(
    baseUrl: String,
    okHttpClient: OkHttpClient,
    converterFactory: Converter.Factory
): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(converterFactory)
        .build()
    return retrofit.create()
}
