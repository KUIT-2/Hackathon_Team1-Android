package com.example.hackathon_team1_android.dao

import com.google.gson.annotations.SerializedName


data class BaseResponse<T>(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: T
)
