package com.techdining.www.wallpage.repository.network

import com.techdining.www.wallpage.BuildConfig
import com.techdining.www.wallpage.dataModel.PhotoItems
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WallpageService {

    @GET("/photos")
    suspend fun displayPhotos(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("client_id") clientId: String = BuildConfig.UNSPLASH_ACCESS_KEY
    ): List<PhotoItems>

    companion object {
        private const val BASE_URL = "https://api.unsplash.com/"

        fun create(): WallpageService {
            val logger = HttpLoggingInterceptor().apply { level = Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WallpageService::class.java)
        }
    }
}