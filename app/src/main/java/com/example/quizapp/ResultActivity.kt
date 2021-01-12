package com.example.quizapp

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.sucess.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var userName= intent.getStringExtra("userName")
        var totalQuestions = intent.getIntExtra("totalQuestion",0)
        var correctAnswers = intent.getIntExtra("correctAnswer",0)
        var result = "Your score is $correctAnswers out of $totalQuestions"

        btn_finish2.setOnClickListener {
            try {
                val dialogBox=Dialog(this)
                dialogBox.setContentView(R.layout.sucess)
                dialogBox.tv_name.text = userName
                dialogBox.tv_result.text = result
                dialogBox.btn_finish.setOnClickListener {
                    dialogBox.hide()
                    startActivity(Intent(this,MainActivity::class.java))

                }
                dialogBox.show()
            } catch (e : Exception) {
                Toast.makeText(this,e.localizedMessage, Toast.LENGTH_LONG).show()
                e.printStackTrace()
            }
        }


        }
    private var doubleBackToExitPressedOnce_ResultActivity = false
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce_ResultActivity) {
            super.onBackPressed()
            finish()
            return
        }

        this.doubleBackToExitPressedOnce_ResultActivity = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()

        Handler().postDelayed({ doubleBackToExitPressedOnce_ResultActivity = false }, 2000)


    }
}