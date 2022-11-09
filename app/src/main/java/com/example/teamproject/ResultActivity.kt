package com.example.teamproject

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import com.example.teamproject.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    lateinit var binding_result: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding_result = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding_result.root)

        val color = Color.rgb(231, 137, 137)

        if(intent.hasExtra("totalProblemNum"))//"totalProblemNum"))
            binding_result.btnNext.text = "최종 결과 확인"


        if(intent.hasExtra("answer")){  //answer만 넘어오면
            val answer = intent.getStringExtra("answer")
            val question = intent.getStringExtra("question")
            val str1 = "\"$question\"은(는) "
            val str2 = "<$answer>"
            val str3 = "입니다."
            val spannable = SpannableString("$str1$str2$str3")
            spannable.setSpan(ForegroundColorSpan(color), str1.length, str1.length + str2.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            binding_result.correctTxt.text = "정답!"
            //binding_result.explainTxt.text = "\"$question\"은(는) <$answer>입니다."
            binding_result.explainTxt.setText(spannable, TextView.BufferType.SPANNABLE)
            binding_result.btnNext.setOnClickListener {
                onBackPressed()

                //만약, 여기로 binding_second.totalCorrectTextView.setText("전체 맞은 문제수: 0")가 넘어오면 , 새로운 activity 로
            }
        }

        if(intent.hasExtra("example")){  //즉, example이 같이 넘어오면 실행합니다.
            val answer = intent.getStringExtra("answer")
            val question = intent.getStringExtra("question")
            val example = intent.getStringExtra("example")
            val str1 = "<$example> : 오답입니다.\n\n\"$question\"은(는) "
            val str2 = "<$answer>"
            val str3 = "입니다."
            val spannable = SpannableString("$str1$str2$str3")
            spannable.setSpan(ForegroundColorSpan(color), str1.length, str1.length + str2.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            binding_result.correctTxt.setBackgroundColor(Color.rgb(231, 137,137))  //이렇게 rgb를 이용해 background의 색을 바꿉니다
            binding_result.correctTxt.text = "오답!"
            //binding_result.explainTxt.text = "<$example> : 오답입니다.\n\n\"$question\"은(는) <$answer>입니다."
            binding_result.explainTxt.setText(spannable, TextView.BufferType.SPANNABLE)
            binding_result.btnNext.setOnClickListener {
                onBackPressed()
            }
        }
    }
}