package com.example.quizapp
/*data class are such type of class, that are independent*/
//This question class will not have any apecial featrure or functionality. It will only have DATA INFORMATION.So we will declare this nQuestion class as Data class
data class Questions(
    val id : Int,
    val question : String,
    val optionOne : String,
    val optionTwo : String,
    val optionThree : String,
    val optionFour : String,
    val correctanswer: Int

)