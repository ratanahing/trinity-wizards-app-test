package com.trinitywizards.apptest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.trinitywizards.apptest.screen.Screen1Activity
import com.trinitywizards.apptest.screen.Screen2Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val screen1 = findViewById<Button>(R.id.btnScreen1)
        val screen2 = findViewById<Button>(R.id.btnScreen2)


        screen1.setOnClickListener {
            // Define the action for button 1 click
            val intent = Intent(this, Screen1Activity::class.java)
            startActivity(intent)
        }

        screen2.setOnClickListener {
            // Define the action for button 2 click
            val intent = Intent(this, Screen2Activity::class.java)
            startActivity(intent)
        }


    }
}