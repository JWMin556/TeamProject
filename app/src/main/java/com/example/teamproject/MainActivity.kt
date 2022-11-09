package com.example.teamproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.teamproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding_main: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding_main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding_main.root) //초기작업

        val firstIntent = Intent(this, FirstActivity::class.java)  //국어 퀴즈를 부르는 Intent입니다.
        val secondIntent = Intent(this, SecondActivity::class.java) //수학 퀴즈를 부르는 Intent입니다.
        val thirdIntent = Intent(this, ThirdActivity::class.java)  //수도 퀴즈를 부르는 Intent입니다.
        val fourthIntent = Intent(this, FourthActivity::class.java)  //속담 퀴즈를 부르는 Intent입니다.
        val fifththIntent = Intent(this, FifthActivity::class.java)  //역사 퀴즈를 부르는 Intent입니다.

        binding_main.btnLanguage.setOnClickListener {
            val subject = "국어"
            firstIntent.putExtra("subject", subject)
            startActivity(firstIntent)
        }

        binding_main.btnMath.setOnClickListener {
            val subject = "수학"
            secondIntent.putExtra("subject", subject)
            startActivity(secondIntent)
        }

        binding_main.btnCapital.setOnClickListener {
            val subject = "수도"
            thirdIntent.putExtra("subject", subject)
            startActivity(thirdIntent)
        }

        binding_main.btnProverb.setOnClickListener {
            val subject = "속담"
            fourthIntent.putExtra("subject", subject)
            startActivity(fourthIntent)
        }

        binding_main.btnHistory.setOnClickListener {
            val subject = "역사"
            fifththIntent.putExtra("subject", subject)
            startActivity(fifththIntent)
        }

    }
}