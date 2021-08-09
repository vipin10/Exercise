package com.rewardz.mylibrarytesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class Dummy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dummy)

        val extras = getIntent().getExtras()
        if (null != extras) {
            val value = extras.getString("name")
            Toast.makeText(applicationContext,"name is"+value,Toast.LENGTH_LONG).show()
            //The key argument here must match that used in the other activity
        }

    }
}