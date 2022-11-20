package com.example.quizapp

import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class QuizQuestion : AppCompatActivity(), View.OnClickListener {
    private var ivCountry: ImageView? = null
    private var pbQuestion: ProgressBar? = null
    private var tvQuestion: TextView? = null
    private var tvOne: TextView? = null
    private var tvTwo: TextView? = null
    private var tvThree: TextView? = null
    private var tvFour: TextView? = null
    private var bSubmit: Button? = null

    private var mQuestionList: ArrayList<Question>? = null
    private var mCurrentPosition: Int = 1

    private var mCorrectAnswer: Int = 0
    private var mSelectedOption: Int = 0

    private var username: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mQuestionList = Constant.getFunction()
        ivCountry = findViewById(R.id.ivCountry)
        pbQuestion = findViewById(R.id.pbQuestion)
        tvQuestion = findViewById(R.id.tvQuestion)
        tvOne = findViewById(R.id.tvOne)
        tvTwo = findViewById(R.id.tvTwo)
        tvThree = findViewById(R.id.tvThree)
        tvFour = findViewById(R.id.tvFour)
        bSubmit = findViewById(R.id.bSubmit)

        tvOne?.setOnClickListener(this)
        tvTwo?.setOnClickListener(this)
        tvThree?.setOnClickListener(this)
        tvFour?.setOnClickListener(this)

        bSubmit?.setOnClickListener(this)
        username = intent.getStringExtra("username")
        getQuestion()
    }

    private fun getQuestion() {
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        if (mCurrentPosition == mQuestionList?.size) {
            bSubmit?.text = "FINISH"
        } else {
            bSubmit?.text = "SUBMIT"
        }

        pbQuestion?.progress = mCurrentPosition
        tvQuestion?.text = "${mCurrentPosition}/${pbQuestion?.max}"

        ivCountry?.setImageResource(question.image)
        tvOne?.text = question.optionOne
        tvTwo?.text = question.optionTwo
        tvThree?.text = question.optionThree
        tvFour?.text = question.optionFour
    }

    override fun onClick(v: View?) {

        val options = ArrayList<TextView>()
        tvOne?.let {
            options.add(0, it)
        }
        tvTwo?.let {
            options.add(1, it)
        }
        tvThree?.let {
            options.add(2, it)
        }
        tvFour?.let {
            options.add(3, it)
        }

        for (option in options) {
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option)
        }

        when (v?.id) {
            R.id.tvOne -> {
                tvOne?.let {
                    mSelectedOption = 1
                    it.setTypeface(it.typeface, Typeface.BOLD)
                    it.background =
                        ContextCompat.getDrawable(this, R.drawable.default_option_selected)
                }
            }
            R.id.tvTwo -> {
                tvTwo?.let {
                    mSelectedOption = 2
                    it.setTypeface(it.typeface, Typeface.BOLD)
                    it.background =
                        ContextCompat.getDrawable(this, R.drawable.default_option_selected)
                }
            }
            R.id.tvThree -> {
                tvThree?.let {
                    mSelectedOption = 3
                    it.setTypeface(it.typeface, Typeface.BOLD)
                    it.background =
                        ContextCompat.getDrawable(this, R.drawable.default_option_selected)
                }
            }
            R.id.tvFour -> {
                tvFour?.let {
                    mSelectedOption = 4
                    it.setTypeface(it.typeface, Typeface.BOLD)
                    it.background =
                        ContextCompat.getDrawable(this, R.drawable.default_option_selected)
                }
            }
            R.id.bSubmit -> {
                if (mSelectedOption == 0) {
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            getQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultPage::class.java)
                            intent.putExtra("score", mCorrectAnswer)
                            intent.putExtra("username", username)
                            Log.e(TAG, "onCreate22222: ${username}", )

                            startActivity(intent)
                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOption) {
                        when (mSelectedOption) {
                            1 -> {
                                tvOne?.background =
                                    ContextCompat.getDrawable(this, R.drawable.default_option_wrong)
                            }
                            2 -> {
                                tvTwo?.background =
                                    ContextCompat.getDrawable(this, R.drawable.default_option_wrong)
                            }
                            3 -> {
                                tvThree?.background =
                                    ContextCompat.getDrawable(this, R.drawable.default_option_wrong)
                            }
                            4 -> {
                                tvFour?.background =
                                    ContextCompat.getDrawable(this, R.drawable.default_option_wrong)
                            }
                        }
                    } else {
                        mCorrectAnswer++
                    }

                    when (question.correctAnswer) {
                        1 -> {
                            tvOne?.background =
                                ContextCompat.getDrawable(this, R.drawable.default_option_correct)
                        }
                        2 -> {
                            tvTwo?.background =
                                ContextCompat.getDrawable(this, R.drawable.default_option_correct)
                        }
                        3 -> {
                            tvThree?.background =
                                ContextCompat.getDrawable(this, R.drawable.default_option_correct)
                        }
                        4 -> {
                            tvFour?.background =
                                ContextCompat.getDrawable(this, R.drawable.default_option_correct)
                        }
                    }
                    if (mCurrentPosition === mQuestionList!!.size) {
                        bSubmit?.text = "FINISH"
                    } else {
                        bSubmit?.text = "NEXT QUESTION"
                    }

                    mSelectedOption = 0
                }
            }
        }

    }
}