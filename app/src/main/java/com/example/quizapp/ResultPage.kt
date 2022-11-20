package com.example.quizapp

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ResultPage : AppCompatActivity() {
    private var tvAnswer : TextView? = null
    private var tvName : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_page)
        tvName = findViewById(R.id.tv_name)
        tvAnswer = findViewById(R.id.tv_score)
        val score = intent.getIntExtra("score",0).toString()
        tvAnswer?.text =  "Your Score is ${score} out of 3"
        tvName?.text = intent.getStringExtra("username")

    }
}