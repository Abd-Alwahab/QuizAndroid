package com.abdalwahab.quizandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.net.Uri
import android.view.View
import android.media.MediaPlayer
import android.media.MediaPlayer.OnPreparedListener



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videoview = findViewById(R.id.background_video) as VideoView
        val uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.video_three)
        videoview.setVideoURI(uri)
        videoview.start()


        videoview.setOnPreparedListener({ mp -> mp.isLooping = true })



    }


    fun openActivity(view: View) {
        startActivity(Intent(this,QuizActivity::class.java))
    }


//    fun playVideo() {
//        val videoview = findViewById(R.id.background_video) as VideoView
//        val uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.video_three)
//        videoview.setVideoURI(uri)
//        videoview.start()
//    }
}
