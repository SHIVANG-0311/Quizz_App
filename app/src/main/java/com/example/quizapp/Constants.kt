package com.example.quizapp

object Constants {

    fun getQuestions(): ArrayList<Questions> {
        val questionsList = ArrayList<Questions>()
        val que1 = Questions(
            1,
            "An error in program, that prevents the program from running as expected.",
            "Mistake",
            "Bug",
            "Error Report",
            "Algorithm",
            2
        )
          questionsList.add(que1)
        val que2 = Questions(
            2,
            "Software Licensing that allows for modification in all cases is called ?",
            "ShareWare",
            "FreeWare",
            "Open source",
            "Closed Project",
            3
        )
        questionsList.add(que2)
        val que3 = Questions(
            3,
            "How many bits make up one letter in binary code ?",
            "8",
            "6",
            "10",
            "4",
            1
        )
        questionsList.add(que3)
        val que4 = Questions(
            4,
            "Which generation of computer languages used the LOAD, ADD and STORE codes",
            "First",
            "Fourth",
            "Third",
            "Second",
            4
        )
        questionsList.add(que4)
        val que5 = Questions(
            5,
            "Which of the following command would not be found in an assembly language ?",
            "SORT",
            "STORE",
            "ADD",
            "LOAD",
            1
        )
        questionsList.add(que5)
        val que6 = Questions(
            6,
            "What is the smallest unit of measurement used to quantify computer data",
            "Marble",
            "a Bridle",
            "a tablespoon",
            "a bit",
            4
        )
        questionsList.add(que6)
        val que7 = Questions(
            7,
            "A list of instructions that enable a computer to perform a specific task is a...",
            "Machine code",
            "Algorithm",
            "Binary Code",
            "Computer Program",
            4
        )
        questionsList.add(que7)
        val que8 = Questions(
            8,
            "An example of a utility software.",
            "Window",
            "Linux",
            "Defragmenter",
            "Excel",
            3
        )
        questionsList.add(que8)
        val que9 = Questions(
            9,
            "A language that is close to human language and which is easy to write, debug and maintain is also known as...",
            "Machine Code",
            "Algorithm",
            "A high level Language",
            "A low level Language",
            3
        )
        questionsList.add(que9)
        val que10 = Questions(
            10,
            "Finding and fixing errors in a program",
            "Debugging",
            "Tech Support",
            "Decompose",
            "Fixing",
            1
        )
        questionsList.add(que10)


        return questionsList
    }
}