package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity() , View.OnClickListener {


    private var mcurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Questions>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mcorrectOption: Int =0
    private var  mUserName:String? = null
    private var  mtotalQuestion:Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        mUserName = intent.getStringExtra("userName")

        mQuestionList = Constants.getQuestions()
        setQuestion()

        tv_optOne.setOnClickListener(this)
        tv_optTwo.setOnClickListener(this)
        tv_optThree.setOnClickListener(this)
        tv_optFour.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    fun setQuestion() {


        val question = mQuestionList!![mcurrentPosition - 1]
        defaultOptionsview()
        if(mcurrentPosition == mQuestionList!!.size){
            btn_submit.text="FINISH"
        }else{
            btn_submit.text="SUBMIT"
        }
        progressBar.progress = mcurrentPosition
        tv_progress.text = "$mcurrentPosition" + "/" + progressBar.max
        tv_question.text = question.question
        tv_optOne.text = question.optionOne
        tv_optTwo.text = question.optionTwo
        tv_optThree.text = question.optionThree
        tv_optFour.text = question.optionFour

    }

    private fun defaultOptionsview() {
        val options = ArrayList<TextView>()
        options.add(0, tv_optOne)
        options.add(1, tv_optTwo)
        options.add(2, tv_optThree)
        options.add(3, tv_optFour)
        for (options in options) {

            options.setTextColor(Color.parseColor("#7A8089"))
            options.typeface = Typeface.DEFAULT
            options.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)

        }


    }

    override fun onClick(v: View?) {


  when (v?.id ){
    R.id.tv_optOne -> {
        selectedOptionView(tv_optOne,1)
    }
    R.id.tv_optTwo -> {
        selectedOptionView(tv_optTwo,2)
    }
    R.id.tv_optThree -> {
        selectedOptionView(tv_optThree,3)
    }
    R.id.tv_optFour -> {
        selectedOptionView(tv_optFour,4)
    }
      R.id.btn_submit -> {
            if(mSelectedOptionPosition==0){

                mcurrentPosition++

                when{
                    mcurrentPosition<=mQuestionList!!.size ->{
                        mtotalQuestion=mQuestionList!!.size
                        setQuestion()
                    }else ->{
                       val intent = Intent(this,ResultActivity::class.java)
                    intent.putExtra("userName",mUserName)
                    intent.putExtra("totalQuestion",mtotalQuestion)
                    intent.putExtra("correctAnswer",mcorrectOption)
                    startActivity(intent)
                    finish()
                  }
                }
            } else{
                val question = mQuestionList?.get(mcurrentPosition - 1)
                if(question!!.correctanswer!= mSelectedOptionPosition){
                    answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                }
                else{
                    mcorrectOption++// mcorrectOption==correctAnswer
                }
                answerView(question.correctanswer,R.drawable.correct_option_border_bg)

                if (mcurrentPosition==mQuestionList!!.size){
                    btn_submit.text = "FINISH"
                }
                else{
                    btn_submit.text = "NEXT"
                }
                mSelectedOptionPosition = 0
            }

         }

       }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){

            1->{
                tv_optOne.background = ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                tv_optTwo.background = ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                tv_optThree.background = ContextCompat.getDrawable(this,drawableView)
            }
            4->{
                tv_optFour.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }


    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionsview()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#000000"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.typeface = Typeface.DEFAULT
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }
    private var doubleBackToExitPressedOnce_QuestionsActivity = false
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce_QuestionsActivity) {
            super.onBackPressed()
            finish()
            return
        }

        this.doubleBackToExitPressedOnce_QuestionsActivity = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()

        Handler().postDelayed({ doubleBackToExitPressedOnce_QuestionsActivity = false }, 2000)

    }


}