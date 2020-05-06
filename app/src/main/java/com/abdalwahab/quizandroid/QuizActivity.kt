package com.abdalwahab.quizandroid

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

import android.os.Handler



class QuizActivity : AppCompatActivity() {


    lateinit var right_answer:TextView
    lateinit var question_word:TextView
    lateinit var user_answer:EditText
    lateinit var change_question:Button
    lateinit var check_answer:Button
    lateinit var show_answer:Button
    lateinit var category:String
    lateinit var random:Random

    var categories = arrayOf("web development" , "android development" , "networking" , "game development" , "video editing" , "phone design" )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)


        init()

        startQuiz()



    }


    fun startQuiz() {

        right_answer.text = ""
        right_answer.visibility = View.INVISIBLE
        category = categories[random.nextInt(categories.size)]
        question_word.text = mixLetters(category)


    }

    fun checkAnswer(view: View) {
        if (user_answer.text.toString().equals(category, ignoreCase = true)) {
            Toast.makeText(this, "Good Job!", Toast.LENGTH_SHORT).show()
            rightAnswer()
            user_answer.text = null



        } else {
            Toast.makeText(this, "Try Again!", Toast.LENGTH_SHORT).show()
            right_answer.text = "Wrong Answer"
            wrongAnswer()

        }
    }


    fun rightAnswer() {

        right_answer.visibility = View.VISIBLE
        right_answer.setBackgroundColor(Color.GREEN)
        right_answer.text = category
        val handler = Handler()
        handler.postDelayed({

            startQuiz()

        }, 3000)   //5 seconds
    }


    fun wrongAnswer() {
        right_answer.visibility = View.VISIBLE
        right_answer.setBackgroundColor(Color.RED)
        val handler = Handler()
        handler.postDelayed({

            startQuiz()

        }, 3000)   //5 seconds
    }



    fun showAnswer(view : View) {
         right_answer.text = category
         rightAnswer()

    }


    fun changeQuestion(view:View) {
        startQuiz()
    }


    fun mixLetters(category: String) : String {

        val characters = category.toCharArray()
        for (i in characters.indices) {
            val randomIndex = (Math.random() * characters.size).toInt()
            val temp = characters[i]
            characters[i] = characters[randomIndex]
            characters[randomIndex] = temp
        }
        return String(characters)
    }


    fun init() {
        right_answer = findViewById(R.id.right_answer)
        question_word = findViewById(R.id.question_word)
        user_answer = findViewById(R.id.user_answer)
        change_question = findViewById(R.id.change_qestion)
        check_answer = findViewById(R.id.check_answer)
        show_answer = findViewById(R.id.show_answer)
        random = Random()
    }


    override fun onBackPressed() {
        super.onBackPressed()

        startActivity(Intent(this,MainActivity::class.java))
    }
}
