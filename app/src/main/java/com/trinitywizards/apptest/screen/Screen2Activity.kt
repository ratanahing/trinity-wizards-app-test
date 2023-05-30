package com.trinitywizards.apptest.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trinitywizards.apptest.R
import com.trinitywizards.apptest.databinding.ActivityScreen2Binding

class Screen2Activity : AppCompatActivity() {

    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: ActivityScreen2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen2)


    }
}