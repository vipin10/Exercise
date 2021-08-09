package com.vipin.exercise

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import com.rewardz.mylibrarytesting.Dummy
import com.vipin.exercise.databinding.ActivityMainBinding
import com.vipin.exercise.utils.Timer

class MainActivity : AppCompatActivity() {

    private val timer = Timer()
    private lateinit var mainActivityMainBinding: ActivityMainBinding
    private var listOfVehicleNames: MutableList<String> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainActivityMainBinding.root
        setContentView(view)
        val someList = arrayListOf("jumping jacks","mountain climbing")

        listOfVehicleNames= listOf("jumping jacks","mountain climbing") as MutableList<String>

        runTimer()

        Toast.makeText(applicationContext,"A simple toast", Toast.LENGTH_LONG).show()



        mainActivityMainBinding.timerTv.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Dummy::class.java)
            intent.putExtra("name","vipin")
            startActivity(intent)

        })

    }

    fun runTimer() {
        object : CountDownTimer(30000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                mainActivityMainBinding.timerTv.setText("seconds remaining: " + millisUntilFinished / 1000)
            }

            override fun onFinish() {
                mainActivityMainBinding.timerTv.setText("done!")
                playSound()
            }
        }.start()
    }

    fun playSound() {

        var resId = getResources().getIdentifier(
            R.raw.alarm.toString(),
            "raw", applicationContext?.packageName
        )

        val mediaPlayer = MediaPlayer.create(applicationContext, resId)
        mediaPlayer.start()
    }
}