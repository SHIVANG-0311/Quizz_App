package com.example.quizapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MydialogBox : AppCompatActivity() {
    var dialogBox:Dialog?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sucess)
        myDialog()
    }
    private fun myDialog(){
        dialogBox= Dialog(this)
        dialogBox!!.setContentView(R.layout.sucess)
        dialogBox!!.show()

    }


}