package dev.incrediblehohol.iprobonusapilib

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal class NetworkService(
    baseUrl: String,
    accessKey: String
) {

    // Таймаут запроса в минутах
    private val timeout = 1L

    private val clientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        .callTimeout(timeout, TimeUnit.MINUTES)
        .connectTimeout(timeout, TimeUnit.MINUTES)
        .readTimeout(timeout, TimeUnit.MINUTES)
        .writeTimeout(timeout, TimeUnit.MINUTES)
        .addInterceptor {
            val request = it.request().newBuilder()
                .addHeader("AccessKey", accessKey)
                .build()
            it.proceed(request)
        }

    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(clientBuilder.build())
        .addConverterFactory(GsonConverterFactory.create())

    private var retrofit: Retrofit = retrofitBuilder.build()

    fun <T> createService(apiClass: Class<T>): T = retrofit.create(apiClass)

    inline fun <T> safeApiCall(responseFunction: () -> T): T? {
        return try {
            responseFunction.invoke()//Or responseFunction()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}