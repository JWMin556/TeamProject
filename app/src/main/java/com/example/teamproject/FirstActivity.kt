package com.example.teamproject

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.teamproject.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    lateinit var binding_first: ActivityFirstBinding
    var problems = arrayOf( //mapOf를 사용해서 문제를 추출합니다.... 배열의 형태로 만들어줬습니다. 물론, 현재는 무작위 추출이 아니고 이 배열의 순서대로 문제가 출력되는 형식으로 했습니다.
        mapOf("question" to "그 아이는 좀 (    )이다.",
            "answer" to "안하무인",
            "example1" to "안아무인",
            "example2" to "아나무인",
            "example3" to "안하무인",
            "example4" to "안놔무인"),
        mapOf("question" to "이 음식은 맛이 (    ).",
            "answer" to "무난하다",
            "example1" to "무나하다",
            "example2" to "문안하다",
            "example3" to "무낭하다",
            "example4" to "무난하다"),
        mapOf("question" to "내 별명은 (    )이다.",
            "answer" to "개구쟁이",
            "example1" to "개구쟁이",
            "example2" to "게구쟁이",
            "example3" to "개구장이",
            "example4" to "게구장이"),
        mapOf("question" to "(    )로 일찍 일어났어?",
            "answer" to "웬일",
            "example1" to "웬일",
            "example2" to "웬닐",
            "example3" to "왠닐",
            "example4" to "왠일"),
        mapOf("question" to "(    )에게 인사를 잘합시다.",
            "answer" to "웃어른",
            "example1" to "위어른",
            "example2" to "욷어른",
            "example3" to "윗어른",
            "example4" to "웃어른"),
        mapOf("question" to "(    ) 놀이동산에 놀러갔습니다.",
            "answer" to "오랜만에",
            "example1" to "오랫만에",
            "example2" to "오래만에",
            "example3" to "오랜만에",
            "example4" to "오랭만에"),
        mapOf("question" to "생각을 (    ) 해봅시다.",
            "answer" to "곰곰이",
            "example1" to "공공이",
            "example2" to "곰곰히",
            "example3" to "곰고미",
            "example4" to "곰곰이"),
        mapOf("question" to "감기에 걸렸다가 다 (    ).",
            "answer" to "나았다",
            "example1" to "나았다",
            "example2" to "낳았다",
            "example3" to "나왔다",
            "example4" to "낳왔다"),
        mapOf("question" to "(    ) 같이 집에 가자.",
            "answer" to "이따가",
            "example1" to "읻다가",
            "example2" to "이따가",
            "example3" to "있다가",
            "example4" to "있따가"),
        mapOf("question" to "너무 황당하고 (    )",
            "answer" to "어이없다",
            "example1" to "어의없다",
            "example2" to "어의업다",
            "example3" to "어이없다",
            "example4" to "어이업다"),

        mapOf("question" to "손을 (    ) 씻어야합니다.",
            "answer" to "깨끗이",
            "example1" to "깨끄시",
            "example2" to "깨끗히",
            "example3" to "깨끗이",
            "example4" to "깨끄치"),
        mapOf("question" to "토끼가 귀를 (    ) 세운다.",
            "answer" to "쫑긋쫑긋",
            "example1" to "쫀끗쫀끗",
            "example2" to "쫑끗쫑끗",
            "example3" to "쫀긋쫀긋",
            "example4" to "쫑긋쫑긋"),
        mapOf("question" to "세수를 해서 (    )을 떼야지.",
            "answer" to "눈곱",
            "example1" to "눙꼽",
            "example2" to "눈꼽",
            "example3" to "눙곱",
            "example4" to "눈곱"),
        mapOf("question" to "힘찬 발걸음을 (    ).",
            "answer" to "내디디다",
            "example1" to "내딛이다",
            "example2" to "내디디다",
            "example3" to "내딪이다",
            "example4" to "내디지다"),
        mapOf("question" to "안전한 (    )",
            "answer" to "학굣길",
            "example1" to "학굗길",
            "example2" to "하꾜길",
            "example3" to "학굣길",
            "example4" to "하교길"),
        mapOf("question" to "개미와 (    )",
            "answer" to "베짱이",
            "example1" to "베짱이",
            "example2" to "배짱이",
            "example3" to "벳짱이",
            "example4" to "뱃장이"),
        mapOf("question" to "예쁜 스티커가 (    ) 벽지",
            "answer" to "붙여진",
            "example1" to "붙혀진",
            "example2" to "붙여진",
            "example3" to "부텨진",
            "example4" to "부처진"),
        mapOf("question" to "(    ) 내 동생",
            "answer" to "예쁜",
            "example1" to "얘쁜",
            "example2" to "에쁜",
            "example3" to "이쁜",
            "example4" to "예쁜"),
        mapOf("question" to "맛있는 (    )",
            "answer" to "김치찌개",
            "example1" to "김치찌개",
            "example2" to "김치찌계",
            "example3" to "김치찌게",
            "example4" to "김치찌걔"),
        mapOf("question" to "거기 (    ) 서서 뭐해?",
            "answer" to "가만히",
            "example1" to "가망이",
            "example2" to "가만히",
            "example3" to "가마니",
            "example4" to "가만이")
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
        binding_first = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding_first.root)

        showProblem(problemNumber)  //문제들을 display합니다.
        if(intent.hasExtra("subject")){
            binding_first.subjectTextView.text = "국어"
        }

        binding_first.example1Button.setOnClickListener {//각 버튼에 따라 selectExample함수를 실행합니다
            binding_first.example1Button.setBackgroundColor(Color.rgb(173, 199, 147))
            selectExample(example1, question)
        }
        binding_first.example2Button.setOnClickListener {
            binding_first.example2Button.setBackgroundColor(Color.rgb(173, 199, 147))
            selectExample(example2, question)
        }
        binding_first.example3Button.setOnClickListener {
            binding_first.example3Button.setBackgroundColor(Color.rgb(173, 199, 147))
            selectExample(example3, question)
        }
        binding_first.example4Button.setOnClickListener {
            binding_first.example4Button.setBackgroundColor(Color.rgb(173, 199, 147))
            selectExample(example4, question)
        }

        //binding_second.totalCorrectTextView.setText("전체 맞은 문제수: 0")
    }

    fun showProblem(pn: Int) { //problemNUmber도 파라미터로 받기(객체지향으로 만들기)
        binding_first.NumberTextView.setText("$problemNumber 번 문제.")

        question = problems[pn - 1]["question"].toString()  //즉, question to 머시기를 String으로 바꿔 question에 넣어줍니다.
        answer = problems[pn - 1]["answer"].toString()
        example1 = problems[pn - 1]["example1"].toString()
        example2 = problems[pn - 1]["example2"].toString()
        example3 = problems[pn - 1]["example3"].toString()
        example4 = problems[pn - 1]["example4"].toString()

        binding_first.questionTextView.text = question  //위에서 만들어준 녀석들을 binding을 통해 화면에 뿌려줍니다.
        binding_first.example1Button.text = example1
        binding_first.example2Button.text = example2
        binding_first.example3Button.text = example3
        binding_first.example4Button.text = example4
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

        binding_first.example1Button.setEnabled(false)
        binding_first.example2Button.setEnabled(false)
        binding_first.example3Button.setEnabled(false)
        binding_first.example4Button.setEnabled(false)
        val h = Handler()
        h.postDelayed({
            binding_first.example1Button.setEnabled(true)
            binding_first.example2Button.setEnabled(true)
            binding_first.example3Button.setEnabled(true)
            binding_first.example4Button.setEnabled(true)

            if (problemNumber < problems.size) {
                problemNumber += 1  //즉, 페이지 수를 올려간다.
                binding_first.example1Button.setBackgroundColor(Color.rgb(255, 255, 255))
                binding_first.example2Button.setBackgroundColor(Color.rgb(255, 255, 255))
                binding_first.example3Button.setBackgroundColor(Color.rgb(255, 255, 255))
                binding_first.example4Button.setBackgroundColor(Color.rgb(255, 255, 255))
                showProblem(problemNumber)
            }
            else {
                binding_first.example1Button.setBackgroundColor(Color.rgb(255, 255, 255))
                binding_first.example2Button.setBackgroundColor(Color.rgb(255, 255, 255))
                binding_first.example3Button.setBackgroundColor(Color.rgb(255, 255, 255))
                binding_first.example4Button.setBackgroundColor(Color.rgb(255, 255, 255))
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