package de.janmeckelholt.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        val questionsList = Constants.getQuestions()
        val progressBar: ProgressBar = findViewById(R.id.pbQuestions)
        val btnNext: Button = findViewById(R.id.btnNext)
        val btnPrev: Button = findViewById(R.id.btnPrev)
        val tvQuestion: TextView = findViewById(R.id.tvQuestion)
        val tvAnswer: TextView = findViewById(R.id.tvAnswer)
        tvQuestion.text = questionsList[progressBar.progress].question
        tvAnswer.text = getCorrectAnswer(questionsList[progressBar.progress])
        progressBar.max = questionsList.size

        btnNext.setOnClickListener {
            if (progressBar.progress < progressBar.max) {
                progressBar.progress++
                if (progressBar.progress < progressBar.max) {
                    tvQuestion.text = questionsList[progressBar.progress].question
                    tvAnswer.text = getCorrectAnswer(questionsList[progressBar.progress])
                } else {
                    tvQuestion.text = "Finished!"
                    tvAnswer.text = "Congratulations!"
                }
            }
            btnNext.isEnabled = (progressBar.progress < progressBar.max)
            btnPrev.isEnabled = (progressBar.progress > 0)
        }
        btnPrev.setOnClickListener {
            if (progressBar.progress > 0) {
                progressBar.progress--
                tvQuestion.text = questionsList[progressBar.progress].question
                tvAnswer.text = getCorrectAnswer(questionsList[progressBar.progress])
            }
            btnPrev.isEnabled = (progressBar.progress > 0)
            btnNext.isEnabled = (progressBar.progress < progressBar.max)
        }

        Log.i("Questionslist-Size", "${questionsList.size}")
    }

    private fun getCorrectAnswer(question: Question): String {
        return when (question.correctAnswer) {
            1 -> question.optionOne
            2 -> question.optionTwo
            3 -> question.optionThree
            4 -> question.optionFour
            else -> "no answer found"
        }
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}