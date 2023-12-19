package com.example.hackathon_team1_android.dao

interface CategorizeView {
    fun CategorizeSuccess()

    fun CategorizeFailure(code: Int, msg: String)
}