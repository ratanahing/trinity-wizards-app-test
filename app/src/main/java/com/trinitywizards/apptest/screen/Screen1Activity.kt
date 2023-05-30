package com.trinitywizards.apptest.screen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.trinitywizards.apptest.R
import com.trinitywizards.apptest.databinding.ActivityScreen1Binding
import com.trinitywizards.apptest.models.Contact

private const val TAG = "Screen1Activity"

class Screen1Activity : AppCompatActivity() {

    private lateinit var viewModel: Screen1ViewModel
    private lateinit var binding: ActivityScreen1Binding
    private lateinit var contactAdapter: ContactAdapter
    private val contacts = mutableListOf<Contact>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen1)


        binding = ActivityScreen1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(Screen1ViewModel::class.java)
        viewModel.getContacts(this)

        viewModel.contacts.observe(this, Observer { contacts ->
            Log.i(TAG, "Number of posts: ${contacts.size}")
            val numElements = contacts.size
            binding.rvContacts.smoothScrollToPosition(numElements)
        })

        viewModel.isLoading.observe(this, Observer { isLoading ->
            Log.i(TAG, "isLoading $isLoading")
        })
        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage == null) {
                // binding.tvError.visibility = View.GONE
            } else {
                // binding.tvError.visibility = View.VISIBLE
                // Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
        })

        contactAdapter = ContactAdapter(this, contacts, object : ContactAdapter.ItemClickListener {
            override fun onItemClick(contact: Contact) {
                // navigate to new activity
                val intent = Intent(this@Screen1Activity, Screen2Activity::class.java)
                // intent.putExtra(EXTRA_POST_ID, post.id)
                startActivity(intent)
            }
        })
        binding.rvContacts.adapter = contactAdapter
        binding.rvContacts.layoutManager = LinearLayoutManager(this)



    }


}