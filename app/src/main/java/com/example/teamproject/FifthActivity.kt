package com.example.teamproject

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.teamproject.databinding.ActivityFifthBinding


class FifthActivity : AppCompatActivity() {
    lateinit var binding_fifth:ActivityFifthBinding
    var problems = arrayOf(  //mapOf를 사용해서 문제를 추출합니다.... 배열의 형태로 만들어줬습니다. 물론, 현재는 무작위 추출이 아니고 이 배열의 순서대로 문제가 출력되는 형식으로 했습니다.
        mapOf("question" to "우리 나라 최초의 국가는?",
            "answer" to "고조선",
            "example1" to "백제",
            "example2" to "고구려",
            "example3" to "신라",
            "example4" to "고조선"),
        mapOf("question" to "‘널리 인간을 이롭게 한다.’는 고조선의 건국 이념은?",
            "answer" to "홍익인간",
            "example1" to "자비",
            "example2" to "홍익인간",
            "example3" to "사랑",
            "example4" to "배고파요"),
        mapOf("question" to "동명 성왕인 주몽이 세운 나라의 이름은?",
            "answer" to "고구려",
            "example1" to "고구려",
            "example2" to "조선",
            "example3" to "고려",
            "example4" to "태봉"),
        mapOf("question" to "100만이 넘는 수나라의 대군을 살수의 얕은 물로 유인하여 거의 전멸시킨 사람은 누구인가?",
            "answer" to "을지문덕",
            "example1" to "주몽",
            "example2" to "이순신",
            "example3" to "을지문덕",
            "example4" to "궁예"),
        mapOf("question" to "일본이 1592년에 조선을 침략하였는데 이 전쟁을 무엇이라고 하는가?",
            "answer" to "임진왜란",
            "example1" to "임진왜란",
            "example2" to "병자호란",
            "example3" to "적벽대전",
            "example4" to "정묘호란"),
        mapOf("question" to "이순신 장군이 적선을 한산도 앞 넓은 바다로 유인하여 학익진 전법으로 크게 무찔러 승리한 싸움은?",
            "answer" to "한산도대첩",
            "example1" to "명량해전",
            "example2" to "노량해전",
            "example3" to "한산도대첩",
            "example4" to "옥포해전"),
        mapOf("question" to "태조 왕건이 세운 나라는?",
            "answer" to "고려",
            "example1" to "마진",
            "example2" to "고려",
            "example3" to "신라",
            "example4" to "동예"),
        mapOf("question" to "훈민정음으로 쓴 최초의 글로 왕실 조상의 역사를 노래한 것은 무엇인가?",
            "answer" to "용비어천가",
            "example1" to "세설실어",
            "example2" to "용비어천가",
            "example3" to "아리랑",
            "example4" to "피리부는 사나이"),
        mapOf("question" to "신사임당의 아들이며 조선 시대의 대표적인 유학자로 10만 양병설을 주장한 사람은 누구인가?",
            "answer" to "이이",
            "example1" to "이황",
            "example2" to "이도",
            "example3" to "정은",
            "example4" to "이이"),
        mapOf("question" to "조선 시대 일본으로 보내던 사신으로 오늘날의 외교 사절에 해당하는 것은?",
            "answer" to "통신사",
            "example1" to "사자",
            "example2" to "해신사",
            "example3" to "통신사",
            "example4" to "연행사"),
        mapOf("question" to " 왕의 친척이나 신하가 강력한 권력을 잡고 온갖 결정을 마음대로 하는 정치 형태를 뭐라고 하나?",
            "answer" to "세도정치",
            "example1" to "탁고",
            "example2" to "세도정치",
            "example3" to "재상정치",
            "example4" to "영의정"),
        mapOf("question" to "기원전 18년 고구려에서 내려온 유이민들이 한강 근처의 위례성에 자리 잡고 세운 나라는?",
            "answer" to "백제",
            "example1" to "백제",
            "example2" to "조선",
            "example3" to "고려",
            "example4" to "옥저"),
        mapOf("question" to "출신 성분에 따라 골과 품으로 등급을 나누는 신라의 신분제도는?",
            "answer" to "골품제",
            "example1" to "과거제",
            "example2" to "연좌제",
            "example3" to "사형제",
            "example4" to "골품제"),
        mapOf("question" to "신라 제27대 왕으로 진평왕의 뒤를 이은 신라 최초의 여왕은?",
            "answer" to "선덕여왕",
            "example1" to "진성여왕",
            "example2" to "장희빈",
            "example3" to "선덕여왕",
            "example4" to "진덕여왕"),
        mapOf("question" to "태조의 셋째 아들로 노비안검법을 제정하고, 958년에 쌍기의 건의에 따라 과거 제도를 실시한 고려 제4대왕은?",
            "answer" to "광종",
            "example1" to "광종",
            "example2" to "명종",
            "example3" to "세종",
            "example4" to "세조"),
        mapOf("question" to "삼국시대에 낙동강 하류의 변한 땅에서 여러 작은 나라들이 모여 연맹체를 이룬 나라는?",
            "answer" to "가야",
            "example1" to "옥저",
            "example2" to "가야",
            "example3" to "동예",
            "example4" to "부여"),
        mapOf("question" to "우리 역사상 가장 넓은 영토를 개척했으며, 해동성국이라 불렸던 나라는?",
            "answer" to "발해",
            "example1" to "발해",
            "example2" to "고구려",
            "example3" to "태봉",
            "example4" to "신라"),
        mapOf("question" to "조선시대 왕들의 재위기간 동안 일어난 일을 편년체 (연대순으로 기록한 역사 서술 방식)로 기록한 역사서는?",
            "answer" to "조선왕조실록",
            "example1" to "징비록",
            "example2" to "조선왕조실록",
            "example3" to "삼국사기",
            "example4" to "직지심체요절"),
        mapOf("question" to "신사임당의 아들이며 조선 시대의 대표적인 유학자로 10만 양병설을 주장한 사람은 누구인가?",
            "answer" to "이이",
            "example1" to "이황",
            "example2" to "이도",
            "example3" to "정은",
            "example4" to "이이"),
        mapOf("question" to "조선시대의 나라를 다스리는 기준이 된 최고의 법전은?",
            "answer" to "경국대전",
            "example1" to "팔만대장경",
            "example2" to "경국대전",
            "example3" to "동학",
            "example4" to "성리학")
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
        binding_fifth = ActivityFifthBinding.inflate(layoutInflater) //이렇게 모든 xml의 요소들 접근가능
        setContentView(binding_fifth.root)  //초기 set

        showProblem(problemNumber)  //문제들을 display합니다.
        if(intent.hasExtra("subject")){
            binding_fifth.subjectTextView.text = "역사"
        }
        binding_fifth.example1Button.setOnClickListener {//각 버튼에 따라 selectExample함수를 실행합니다
            binding_fifth.example1Button.setBackgroundColor(Color.rgb(173, 199, 147))
            selectExample(example1, question)
        }
        binding_fifth.example2Button.setOnClickListener {
            binding_fifth.example2Button.setBackgroundColor(Color.rgb(173, 199, 147))
            selectExample(example2, question)
        }
        binding_fifth.example3Button.setOnClickListener {
            binding_fifth.example3Button.setBackgroundColor(Color.rgb(173, 199, 147))
            selectExample(example3, question)
        }
        binding_fifth.example4Button.setOnClickListener {
            binding_fifth.example4Button.setBackgroundColor(Color.rgb(173, 199, 147))
            selectExample(example4, question)
        }

        //binding_fifth.totalCorrectTextView.setText("전체 맞은 문제수: 0")
    }

    fun showProblem(pn: Int) { //problemNUmber도 파라미터로 받기(객체지향으로 만들기)
        binding_fifth.NumberTextView.setText("$problemNumber 번 문제.")

        question = problems[pn - 1]["question"].toString()  //즉, question to 머시기를 String으로 바꿔 question에 넣어줍니다.
        answer = problems[pn - 1]["answer"].toString()
        example1 = problems[pn - 1]["example1"].toString()
        example2 = problems[pn - 1]["example2"].toString()
        example3 = problems[pn - 1]["example3"].toString()
        example4 = problems[pn - 1]["example4"].toString()

        binding_fifth.questionTextView.text = question  //위에서 만들어준 녀석들을 binding을 통해 화면에 뿌려줍니다.
        binding_fifth.example1Button.text = example1
        binding_fifth.example2Button.text = example2
        binding_fifth.example3Button.text = example3
        binding_fifth.example4Button.text = example4
    }

    fun selectExample(example: String, question: String) {  //이 함수는 버튼을 클릭했을 때, 사용하는 함수입니다.
        val resultIntent = Intent(this, ResultActivity::class.java)
        if (answer == example) {  //즉, 사용자가 입력한 값이 정답일때
            if(totalProblemNum == problemNumber)  //만약, 문제가 다 끝났으면
                resultIntent.putExtra("totalProblemNum", totalProblemNum)
            totalCorrect += 1
            //binding_fifth.totalCorrectTextView.setText("전체 맞은 문제수: ${totalCorrect.toString()}")
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

        binding_fifth.example1Button.setEnabled(false)
        binding_fifth.example2Button.setEnabled(false)
        binding_fifth.example3Button.setEnabled(false)
        binding_fifth.example4Button.setEnabled(false)
        val h = Handler()
        h.postDelayed({
            binding_fifth.example1Button.setEnabled(true)
            binding_fifth.example2Button.setEnabled(true)
            binding_fifth.example3Button.setEnabled(true)
            binding_fifth.example4Button.setEnabled(true)

            if (problemNumber < problems.size) {
                problemNumber += 1  //즉, 페이지 수를 올려간다.
                binding_fifth.example1Button.setBackgroundColor(Color.rgb(255, 255, 255))
                binding_fifth.example2Button.setBackgroundColor(Color.rgb(255, 255, 255))
                binding_fifth.example3Button.setBackgroundColor(Color.rgb(255, 255, 255))
                binding_fifth.example4Button.setBackgroundColor(Color.rgb(255, 255, 255))
                showProblem(problemNumber)
            }
            else {
                binding_fifth.example1Button.setBackgroundColor(Color.rgb(255, 255, 255))
                binding_fifth.example2Button.setBackgroundColor(Color.rgb(255, 255, 255))
                binding_fifth.example3Button.setBackgroundColor(Color.rgb(255, 255, 255))
                binding_fifth.example4Button.setBackgroundColor(Color.rgb(255, 255, 255))
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