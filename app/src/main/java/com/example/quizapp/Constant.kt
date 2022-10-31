package com.example.quizapp

object Constant {
    fun getFunction():ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val que1 = Question(1,"Country name?", R.drawable.ic_flag_of_argentina,"Argentina", "Australia", "India", "Brazil",1);
        val que2 = Question(2,"Country name?", R.drawable.ic_flag_of_australia,"Argentina", "Australia", "India", "Brazil",2);
        val que3 = Question(3,"Country name?", R.drawable.ic_flag_of_belgium,"Argentina", "Australia", "Belgium", "Brazil",3);
        questionList.add(que1)
        questionList.add(que2)
        questionList.add(que3)
        return questionList
    }
}