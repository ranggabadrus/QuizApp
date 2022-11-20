package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonStart: Button = findViewById(R.id.btnStart)
        val editName: TextInputEditText = findViewById(R.id.edtName)
        buttonStart.setOnClickListener {
            if (editName.text.toString().isEmpty()) {
                Toast.makeText(this, "Text input is empty", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, QuizQuestion::class.java)
                intent.putExtra("username", editName.text.toString())
                startActivity(intent)
            }
        }
    }
}