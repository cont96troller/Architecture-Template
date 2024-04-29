package com.yoohyun.data.api

import android.content.Context
import com.google.gson.GsonBuilder
import com.yoohyun.data.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


fun <T> createRetrofit(baseUrl: String, serviceClass: Class<T>, factory: Converter.Factory? = null): T {
    val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    val builder = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
    if (BuildConfig.DEBUG) {
        builder.addInterceptor(logger)
    }
    val client = builder.build()
    val converterFactory = factory ?: run {
        val gson = GsonBuilder().create()
        GsonConverterFactory.create(gson)
    }
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(converterFactory)
        .build()
        .create(serviceClass)
}

fun <T> createTestRetrofit(
    baseUrl: String,
    context: Context,
    serviceClass: Class<T>
): T {
    val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    return Retrofit.Builder()
        .client(
            OkHttpClient.Builder()
                .addInterceptor(logger)
//                .addInterceptor(MockInterceptor(context))
                .build()
        )
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()
        .create(serviceClass)
}