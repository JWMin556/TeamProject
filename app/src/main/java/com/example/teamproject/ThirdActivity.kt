package com.example.teamproject

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.teamproject.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    lateinit var binding_third : ActivityThirdBinding
    var problems = arrayOf( //mapOf를 사용해서 문제를 추출합니다.... 배열의 형태로 만들어줬습니다. 물론, 현재는 무작위 추출이 아니고 이 배열의 순서대로 문제가 출력되는 형식으로 했습니다.
        mapOf("question" to "스웨덴의 수도는?",
            "answer" to "스톡홀름",
            "example1" to "함마르비",
            "example2" to "스톡홀름",
            "example3" to "코펜하겐",
            "example4" to "헬싱키"),
        mapOf("question" to "말레이시아의 수도는?",
            "answer" to "쿠알라룸푸르",
            "example1" to "쿠알라룸푸르",
            "example2" to "마닐라",
            "example3" to "코타키나발루",
            "example4" to "자카르타"),
        mapOf("question" to "독일의 수도는??",
            "answer" to "베를린",
            "example1" to "뮌헨",
            "example2" to "프랑크푸르트",
            "example3" to "베를린",
            "example4" to "잘츠부르크"),
        mapOf("question" to "중국의 수도는?",
            "answer" to "베이징",
            "example1" to "상하이",
            "example2" to "타이베이",
            "example3" to "베이징",
            "example4" to "칭타오"),
        mapOf("question" to "가나의 수도는?",
            "answer" to "아크라",
            "example1" to "쿠마시",
            "example2" to "타말",
            "example3" to "로메",
            "example4" to "아크라"),
        mapOf("question" to "프랑스의 수도는?",
            "answer" to "파리",
            "example1" to "파리",
            "example2" to "니스",
            "example3" to "리옹",
            "example4" to "브뤼셀"),
        mapOf("question" to "스페인의 수도는?",
            "answer" to "마드리드",
            "example1" to "바르셀로나",
            "example2" to "마드리드",
            "example3" to "그라나다",
            "example4" to "리스본"),
        mapOf("question" to "헝가리의 수도는?",
            "answer" to "부다페스트",
            "example1" to "부쿠레슈티",
            "example2" to "부다페스트",
            "example3" to "리스본",
            "example4" to "자그레브"),
        mapOf("question" to "룩셈부르크의 수도는?",
            "answer" to "룩셈부르크",
            "example1" to "릴",
            "example2" to "룩셈부르크",
            "example3" to "크노케",
            "example4" to "퀼른"),
        mapOf("question" to "불가리아의 수도는?",
            "answer" to "소피아",
            "example1" to "베오그라드",
            "example2" to "소피아",
            "example3" to "부큐레슈티",
            "example4" to "바르나"),
        mapOf("question" to "멕시코의 수도는?",
            "answer" to "멕시코시티",
            "example1" to "칸쿤",
            "example2" to "멕시코시티",
            "example3" to "리마",
            "example4" to "벨모판"),
        mapOf("question" to "베네수엘라의 수도는?",
            "answer" to "카라카스",
            "example1" to "보고타",
            "example2" to "로조우",
            "example3" to "카라카스",
            "example4" to "죠지타운"),
        mapOf("question" to "쿠바의 수도는?",
            "answer" to "하바나",
            "example1" to "포르토프랭스",
            "example2" to "킹스턴",
            "example3" to "낫소",
            "example4" to "하바나"),
        mapOf("question" to "영국의 수도는?",
            "answer" to "런던",
            "example1" to "웰링턴",
            "example2" to "더블린",
            "example3" to "런던",
            "example4" to "맨체스터"),
        mapOf("question" to "러시아의 수도는?",
            "answer" to "모스크바",
            "example1" to "블라디보스톡",
            "example2" to "모스크바",
            "example3" to "상트페테르부르크",
            "example4" to "아스타나"),
        mapOf("question" to "베트남의 수도는?",
            "answer" to "하노이",
            "example1" to "말레",
            "example2" to "하노이",
            "example3" to "팀푸",
            "example4" to "네피도"),
        mapOf("question" to "몽골의 수도는?",
            "answer" to "울란바토르",
            "example1" to "울란바토르",
            "example2" to "바쿠",
            "example3" to "무스카트",
            "example4" to "사나"),
        mapOf("question" to "싱가포르의 수도는?",
            "answer" to "싱가포르",
            "example1" to "테헤란",
            "example2" to "싱가포르",
            "example3" to "자카르타",
            "example4" to "트빌리시"),
        mapOf("question" to "대한민국의 수도는?",
            "answer" to "서울",
            "example1" to "부산",
            "example2" to "평양",
            "example3" to "도쿄",
            "example4" to "서울"),
        mapOf("question" to "네팔의 수도는?",
            "answer" to "카트만두",
            "example1" to "리야드",
            "example2" to "자카르타",
            "example3" to "카트만두",
            "example4" to "예루살렘")
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
        binding_third = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding_third.root)

        showProblem(problemNumber)  //문제들을 display합니다.
        if(intent.hasExtra("subject")){
            binding_third.subjectTextView.text = "수도"
        }

        binding_third.example1Button.setOnClickListener {//각 버튼에 따라 selectExample함수를 실행합니다
            selectExample(example1, question)
        }
        binding_third.example2Button.setOnClickListener {
            selectExample(example2, question)
        }
        binding_third.example3Button.setOnClickListener {
            selectExample(example3, question)
        }
        binding_third.example4Button.setOnClickListener {
            selectExample(example4, question)
        }

        //binding_second.totalCorrectTextView.setText("전체 맞은 문제수: 0")
    }

    fun showProblem(pn: Int) { //problemNUmber도 파라미터로 받기(객체지향으로 만들기)
        binding_third.NumberTextView.setText("$problemNumber 번 문제.")

        question = problems[pn - 1]["question"].toString()  //즉, question to 머시기를 String으로 바꿔 question에 넣어줍니다.
        answer = problems[pn - 1]["answer"].toString()
        example1 = problems[pn - 1]["example1"].toString()
        example2 = problems[pn - 1]["example2"].toString()
        example3 = problems[pn - 1]["example3"].toString()
        example4 = problems[pn - 1]["example4"].toString()

        binding_third.questionTextView.text = question  //위에서 만들어준 녀석들을 binding을 통해 화면에 뿌려줍니다.
        binding_third.example1Button.text = example1
        binding_third.example2Button.text = example2
        binding_third.example3Button.text = example3
        binding_third.example4Button.text = example4
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

        binding_third.example1Button.setEnabled(false)
        binding_third.example2Button.setEnabled(false)
        binding_third.example3Button.setEnabled(false)
        binding_third.example4Button.setEnabled(false)
        val h = Handler()
        h.postDelayed({
            binding_third.example1Button.setEnabled(true)
            binding_third.example2Button.setEnabled(true)
            binding_third.example3Button.setEnabled(true)
            binding_third.example4Button.setEnabled(true)

            if (problemNumber < problems.size) {
                problemNumber += 1  //즉, 페이지 수를 올려간다.
                showProblem(problemNumber)
            }
            else {
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