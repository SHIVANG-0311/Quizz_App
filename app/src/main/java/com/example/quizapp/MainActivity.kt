package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        btn_start.setOnClickListener {
            if (et_name.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()

            } else {
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra("userName", et_name.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
    private var doubleBackToExitPressedOnce_MainActivity = false
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce_MainActivity) {
            super.onBackPressed()
            finish()
            return
        }
        this.doubleBackToExitPressedOnce_MainActivity = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({ doubleBackToExitPressedOnce_MainActivity = false }, 2000)

    }




//override fun onBackPressed() {
//    var pressedTime:Long? = null
//    if (pressedTime != null) {
//        if (pressedTime + 2000 > System.currentTimeMillis()) {
//            super.onBackPressed()
//            finish()
//        } else {
//            Toast.makeText(baseContext, "Press back again to exit", Toast.LENGTH_SHORT).show()
//        }
//    }
//    System.currentTimeMillis()
//}

}