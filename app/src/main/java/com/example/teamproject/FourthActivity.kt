package com.example.teamproject

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.teamproject.databinding.ActivityFourthBinding

class FourthActivity : AppCompatActivity() {
    lateinit var binding_fourth : ActivityFourthBinding
    var problems = arrayOf(  //mapOf를 사용해서 문제를 추출합니다.... 배열의 형태로 만들어줬습니다. 물론, 현재는 무작위 추출이 아니고 이 배열의 순서대로 문제가 출력되는 형식으로 했습니다.
        mapOf("question" to "(    ) 목에 방울 달기",
            "answer" to "고양이",
            "example1" to "개",
            "example2" to "고양이",
            "example3" to "토끼",
            "example4" to "사자"),
        mapOf("question" to "까마귀 날자 (    ) 떨어진다",
            "answer" to "배",
            "example1" to "배",
            "example2" to "사과",
            "example3" to "복숭아",
            "example4" to "감"),
        mapOf("question" to "달면 삼키고 (    ) 뱉는다",
            "answer" to "쓰면",
            "example1" to "짜면",
            "example2" to "시면",
            "example3" to "상하면",
            "example4" to "쓰면"),
        mapOf("question" to "등잔 (    ) 어둡다",
            "answer" to "밑이",
            "example1" to "밑이",
            "example2" to "위가",
            "example3" to "오른쪽이",
            "example4" to "왼쪽이"),
        mapOf("question" to "말이 (    ) 된다",
            "answer" to "씨가",
            "example1" to "씨가",
            "example2" to "뿌리가",
            "example3" to "거짓말이",
            "example4" to "안"),
        mapOf("question" to "미운 아이 (    ) 하나 더 준다",
            "answer" to "떡",
            "example1" to "사탕",
            "example2" to "곶감",
            "example3" to "떡",
            "example4" to "초콜릿"),
        mapOf("question" to "바늘 도둑이 (    ) 된다",
            "answer" to "소도둑",
            "example1" to "부자",
            "example2" to "소도둑",
            "example3" to "거지",
            "example4" to "실도둑"),
        mapOf("question" to "사공이 많으면 배가 (    ) 간다",
            "answer" to "산으로",
            "example1" to "사막으로",
            "example2" to "들로",
            "example3" to "바다로",
            "example4" to "산으로"),
        mapOf("question" to "(    )도 밟으면 꿈틀한다",
            "answer" to "지렁이",
            "example1" to "개미",
            "example2" to "거미",
            "example3" to "꿀벌",
            "example4" to "지렁이"),
        mapOf("question" to "(    )도 제 말하면 온다",
            "answer" to "호랑이",
            "example1" to "호랑이",
            "example2" to "사람",
            "example3" to "앵무새",
            "example4" to "코끼리"),

        mapOf("question" to "(    )도 약에 쓰려면 없다",
            "answer" to "개똥",
            "example1" to "꽃",
            "example2" to "음식",
            "example3" to "개똥",
            "example4" to "떡"),
        mapOf("question" to "닭 잡아먹고 (    ) 내민다",
            "answer" to "오리발",
            "example1" to "오리발",
            "example2" to "닭발",
            "example3" to "오리머리",
            "example4" to "닭머리"),
        mapOf("question" to "도둑이 (    ) 저리다",
            "answer" to "제 발",
            "example1" to "제 발",
            "example2" to "제 손",
            "example3" to "뼈가",
            "example4" to "가슴이"),
        mapOf("question" to "(    ) 겉 핥기",
            "answer" to "수박",
            "example1" to "콩",
            "example2" to "수박",
            "example3" to "사과",
            "example4" to "레몬"),
        mapOf("question" to "우물 안 (    )",
            "answer" to "개구리",
            "example1" to "물",
            "example2" to "개구리",
            "example3" to "물",
            "example4" to "물고기"),
        mapOf("question" to "(    )가 방앗간을 그냥 지나치랴",
            "answer" to "참새",
            "example1" to "앵무새",
            "example2" to "참새",
            "example3" to "독수리",
            "example4" to "비둘기"),
        mapOf("question" to "자라 보고 놀란 가슴 (    ) 보고 놀란다",
            "answer" to "솥뚜껑",
            "example1" to "낫",
            "example2" to "바늘",
            "example3" to "도끼",
            "example4" to "솥뚜껑"),
        mapOf("question" to "목마른 사람이 (    ) 판다",
            "answer" to "우물",
            "example1" to "생수",
            "example2" to "우물",
            "example3" to "음료수",
            "example4" to "시냇물"),
        mapOf("question" to "(    )도 나무에서 떨어진다",
            "answer" to "원숭이",
            "example1" to "참새",
            "example2" to "원숭이",
            "example3" to "나무늘보",
            "example4" to "개"),
        mapOf("question" to "(    )이 넝쿨째로 굴러 들어온다",
            "answer" to "호박",
            "example1" to "나뭇잎",
            "example2" to "꽃",
            "example3" to "수박",
            "example4" to "호박")
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
        binding_fourth = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding_fourth.root)

        showProblem(problemNumber)  //문제들을 display합니다.
        if(intent.hasExtra("subject")){
            binding_fourth.subjectTextView.text = "속담"
        }

        binding_fourth.example1Button.setOnClickListener {//각 버튼에 따라 selectExample함수를 실행합니다
            selectExample(example1, question)
        }
        binding_fourth.example2Button.setOnClickListener {
            selectExample(example2, question)
        }
        binding_fourth.example3Button.setOnClickListener {
            selectExample(example3, question)
        }
        binding_fourth.example4Button.setOnClickListener {
            selectExample(example4, question)
        }

        //binding_second.totalCorrectTextView.setText("전체 맞은 문제수: 0")
    }

    fun showProblem(pn: Int) { //problemNUmber도 파라미터로 받기(객체지향으로 만들기)
        binding_fourth.NumberTextView.setText("$problemNumber 번 문제.")

        question = problems[pn - 1]["question"].toString()  //즉, question to 머시기를 String으로 바꿔 question에 넣어줍니다.
        answer = problems[pn - 1]["answer"].toString()
        example1 = problems[pn - 1]["example1"].toString()
        example2 = problems[pn - 1]["example2"].toString()
        example3 = problems[pn - 1]["example3"].toString()
        example4 = problems[pn - 1]["example4"].toString()

        binding_fourth.questionTextView.text = question  //위에서 만들어준 녀석들을 binding을 통해 화면에 뿌려줍니다.
        binding_fourth.example1Button.text = example1
        binding_fourth.example2Button.text = example2
        binding_fourth.example3Button.text = example3
        binding_fourth.example4Button.text = example4
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

        binding_fourth.example1Button.setEnabled(false)
        binding_fourth.example2Button.setEnabled(false)
        binding_fourth.example3Button.setEnabled(false)
        binding_fourth.example4Button.setEnabled(false)
        val h = Handler()
        h.postDelayed({
            binding_fourth.example1Button.setEnabled(true)
            binding_fourth.example2Button.setEnabled(true)
            binding_fourth.example3Button.setEnabled(true)
            binding_fourth.example4Button.setEnabled(true)

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