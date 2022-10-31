package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultPage : AppCompatActivity() {
    private var tvAnswer : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_page)

        tvAnswer = findViewById(R.id.answer)
        tvAnswer?.text = intent.getIntExtra("score",0).toString()
    }
}