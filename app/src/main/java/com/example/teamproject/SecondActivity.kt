package com.example.teamproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.os.Handler
import com.example.teamproject.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding_second: ActivitySecondBinding   //이렇게 모든 xml의 요소들 접근가능
    var problems = arrayOf(  //mapOf를 사용해서 문제를 추출합니다.... 배열의 형태로 만들어줬습니다. 물론, 현재는 무작위 추출이 아니고 이 배열의 순서대로 문제가 출력되는 형식으로 했습니다.
        mapOf("question" to "1 + 2 = ?",
            "answer" to "3",
            "example1" to "1",
            "example2" to "3",
            "example3" to "2",
            "example4" to "4"),
        mapOf("question" to "3 x 2 = ?",
            "answer" to "6",
            "example1" to "4",
            "example2" to "6",
            "example3" to "5",
            "example4" to "2"),
        mapOf("question" to "5 - 3 = ?",
            "answer" to "2",
            "example1" to "6",
            "example2" to "1",
            "example3" to "5",
            "example4" to "2"),
        mapOf("question" to "8 ÷ 4 = ?",
            "answer" to "2",
            "example1" to "1",
            "example2" to "2",
            "example3" to "4",
            "example4" to "3"),
        mapOf("question" to "4 + 2 = ?",
            "answer" to "6",
            "example1" to "6",
            "example2" to "4",
            "example3" to "2",
            "example4" to "5"),
        mapOf("question" to "5 - 4 = ?",
            "answer" to "1",
            "example1" to "3",
            "example2" to "6",
            "example3" to "7",
            "example4" to "1"),
        mapOf("question" to "4 x 3 = ?",
            "answer" to "12",
            "example1" to "7",
            "example2" to "12",
            "example3" to "8",
            "example4" to "3"),
        mapOf("question" to "9 ÷ 3 = ?",
            "answer" to "3",
            "example1" to "7",
            "example2" to "3",
            "example3" to "5",
            "example4" to "4"),
        mapOf("question" to "1 + 4 = ?",
            "answer" to "5",
            "example1" to "4",
            "example2" to "5",
            "example3" to "0",
            "example4" to "6"),
        mapOf("question" to "3 + 1 = ?",
            "answer" to "4",
            "example1" to "8",
            "example2" to "3",
            "example3" to "4",
            "example4" to "0"),
        mapOf("question" to "5 x 5 = ?",
            "answer" to "25",
            "example1" to "23",
            "example2" to "25",
            "example3" to "27",
            "example4" to "29"),
        mapOf("question" to "6 x 8 = ?",
            "answer" to "48",
            "example1" to "48",
            "example2" to "50",
            "example3" to "52",
            "example4" to "54"),
        mapOf("question" to "9 ÷ 3 = ?",
            "answer" to "3",
            "example1" to "1",
            "example2" to "2",
            "example3" to "3",
            "example4" to "4"),
        mapOf("question" to "8 ÷ 4 = ?",
            "answer" to "2",
            "example1" to "2",
            "example2" to "4",
            "example3" to "6",
            "example4" to "8"),
        mapOf("question" to "4 x 2 = ?",
            "answer" to "8",
            "example1" to "3",
            "example2" to "4",
            "example3" to "8",
            "example4" to "11"),
        mapOf("question" to "5 x 4 = ?",
            "answer" to "20",
            "example1" to "16",
            "example2" to "18",
            "example3" to "20",
            "example4" to "22"),
        mapOf("question" to "4 + 3 = ?",
            "answer" to "7",
            "example1" to "7",
            "example2" to "12",
            "example3" to "8",
            "example4" to "3"),
        mapOf("question" to "9 x 3 = ?",
            "answer" to "27",
            "example1" to "27",
            "example2" to "30",
            "example3" to "33",
            "example4" to "36"),
        mapOf("question" to "15 ÷ 3 = ?",
            "answer" to "5",
            "example1" to "4",
            "example2" to "5",
            "example3" to "0",
            "example4" to "6"),
        mapOf("question" to "9 x 7 = ?",
            "answer" to "63",
            "example1" to "61",
            "example2" to "63",
            "example3" to "65",
            "example4" to "67")
    )
    var problemNumber = 1 //problemNUmber는 화면에 직접적으로 display이 되지 않지만, 다음 페이지로 넘어가기위한 페이지 역할을 수행합니다. 그렇기에 이 변수는 계속 숫자가 바뀌므로 var로 선언했습니다.
    val totalProblemNum = 20  //전체 문제수입니다.
    var question = ""
    var answer = ""
    var example1 = ""
    var example2 = ""
    var example3 = ""
    var example4 = ""
    //숫자표시
    var totalCorrect = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding_second = ActivitySecondBinding.inflate(layoutInflater) //이렇게 모든 xml의 요소들 접근가능
        setContentView(binding_second.root)  //초기 set

        showProblem(problemNumber)  //문제들을 display합니다.
        if(intent.hasExtra("subject")){
            binding_second.subjectTextView.text = "수학"
        }

        binding_second.example1Button.setOnClickListener {//각 버튼에 따라 selectExample함수를 실행합니다
            binding_second.example1Button.setBackgroundColor(Color.rgb(173, 199, 147))
            selectExample(example1, question)
        }
        binding_second.example2Button.setOnClickListener {
            binding_second.example2Button.setBackgroundColor(Color.rgb(173, 199, 147))
            selectExample(example2, question)
        }
        binding_second.example3Button.setOnClickListener {
            binding_second.example3Button.setBackgroundColor(Color.rgb(173, 199, 147))
            selectExample(example3, question)
        }
        binding_second.example4Button.setOnClickListener {
            binding_second.example4Button.setBackgroundColor(Color.rgb(173, 199, 147))
            selectExample(example4, question)
        }

        //binding_second.totalCorrectTextView.setText("전체 맞은 문제수: 0")
    }

    fun showProblem(pn: Int) { //problemNUmber도 파라미터로 받기(객체지향으로 만들기)
        binding_second.NumberTextView.setText("$problemNumber 번 문제")

        question = problems[pn - 1]["question"].toString()  //즉, question to 머시기를 String으로 바꿔 question에 넣어줍니다.
        answer = problems[pn - 1]["answer"].toString()
        example1 = problems[pn - 1]["example1"].toString()
        example2 = problems[pn - 1]["example2"].toString()
        example3 = problems[pn - 1]["example3"].toString()
        example4 = problems[pn - 1]["example4"].toString()

        binding_second.questionTextView.text = question  //위에서 만들어준 녀석들을 binding을 통해 화면에 뿌려줍니다.
        binding_second.example1Button.text = example1
        binding_second.example2Button.text = example2
        binding_second.example3Button.text = example3
        binding_second.example4Button.text = example4
    }

    fun selectExample(example: String, question: String) {  //이 함수는 버튼을 클릭했을 때, 사용하는 함수입니다.
        val resultIntent = Intent(this, ResultActivity::class.java)
        if (answer == example) {  //즉, 사용자가 입력한 값이 정답일때
            if(totalProblemNum == problemNumber)  //만약, 문제가 다 끝났으면
                resultIntent.putExtra("totalProblemNum", totalProblemNum)
            totalCorrect += 1
            //binding_second.totalCorrectTextView.setText("전체 맞은 문제수: ${totalCorrect.toString()}")
            resultIntent.putExtra("answer", answer)
            resultIntent.putExtra("question", question)
            startActivity(resultIntent)
        } else {
            if(totalProblemNum == problemNumber)  //만약, 문제가 다 끝났으면
                resultIntent.putExtra("totalProblemNum", totalProblemNum)
            resultIntent.putExtra("example", example)
            resultIntent.putExtra("answer", answer)
            resultIntent.putExtra("question", question)
            startActivity(resultIntent)
        }

        binding_second.example1Button.setEnabled(false)
        binding_second.example2Button.setEnabled(false)
        binding_second.example3Button.setEnabled(false)
        binding_second.example4Button.setEnabled(false)
        val h = Handler()
        h.postDelayed({
            binding_second.example1Button.setEnabled(true)
            binding_second.example2Button.setEnabled(true)
            binding_second.example3Button.setEnabled(true)
            binding_second.example4Button.setEnabled(true)

            if (problemNumber < problems.size) {
                problemNumber += 1  //즉, 페이지 수를 올려간다.
                binding_second.example1Button.setBackgroundColor(Color.rgb(255, 255, 255))
                binding_second.example2Button.setBackgroundColor(Color.rgb(255, 255, 255))
                binding_second.example3Button.setBackgroundColor(Color.rgb(255, 255, 255))
                binding_second.example4Button.setBackgroundColor(Color.rgb(255, 255, 255))
                showProblem(problemNumber)
            }
            else {
                binding_second.example1Button.setBackgroundColor(Color.rgb(255, 255, 255))
                binding_second.example2Button.setBackgroundColor(Color.rgb(255, 255, 255))
                binding_second.example3Button.setBackgroundColor(Color.rgb(255, 255, 255))
                binding_second.example4Button.setBackgroundColor(Color.rgb(255, 255, 255))
                showGameOverBox()
            }
        }, 1000)
    }

    fun showGameOverBox() {
        val alertDialog = AlertDialog.Builder(this)
            .setTitle("게임 종료")
            .setMessage("게임을 다시 하실래요?")
            .setNegativeButton("앱 종료") { dialog, id -> exitApp() }
            .setPositiveButton("다시 할래요") { dialog, id -> replay() }
            .setCancelable(false) //true by default
            .create()
        alertDialog.show()
    }

    fun exitApp() {
        finishAffinity()
    }

    fun replay() {
        val mainIntent = Intent(this,MainActivity::class.java)
        startActivity(mainIntent)
    }
}