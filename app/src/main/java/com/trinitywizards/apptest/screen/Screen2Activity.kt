package com.trinitywizards.apptest.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.trinitywizards.apptest.R
import com.trinitywizards.apptest.databinding.ActivityScreen2Binding

class Screen2Activity : AppCompatActivity() {

    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: ActivityScreen2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen2)

        binding = ActivityScreen2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val postId = intent.getIntExtra(EXTRA_CONTACT_ID, -1)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.isLoading.observe(this, Observer { isLoading ->
            // binding.detailProgressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            // binding.clContent.visibility = if (isLoading) View.GONE else View.VISIBLE
        })
        viewModel.contact.observe(this, Observer { post ->
            // binding.tvPostId.text = "Post #${post.id}"
            // binding.tvTitle.text = post.title
            // binding.tvBody.text = post.content
        })

        viewModel.getContactDetails(postId)


    }
}