package com.example.hackathon_team1_android

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hackathon_team1_android.ui.home.MainFragment
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_splash)
        moveMain(1000)
    }

    private fun moveMain(sec: Long) {
        Handler().postDelayed(Runnable {
            //new Intent(현재 context, 이동할 activity)
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent) //intent 에 명시된 액티비티로 이동
            finish() //현재 액티비티 종료
        }, 1 * sec) // sec초 정도 딜레이를 준 후 시작
    }
}