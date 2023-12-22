package com.example.hackathon_team1_android

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApplicationClass : Application() {
    companion object {
        lateinit var retrofit: Retrofit
        const val BASE_URL: String = "https://fe4a-210-106-232-126.ngrok-free.app/"
    }

    override fun onCreate() {
        super.onCreate()

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}