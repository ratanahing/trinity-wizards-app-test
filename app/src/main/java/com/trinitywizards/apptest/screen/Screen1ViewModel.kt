package com.trinitywizards.apptest.screen

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.trinitywizards.apptest.getJsonDataFromAsset
import com.trinitywizards.apptest.models.Contact
import kotlinx.coroutines.launch
import java.lang.Exception

class Screen1ViewModel: ViewModel() {

    private val _contacts: MutableLiveData<List<Contact>> = MutableLiveData()
    val contacts: LiveData<List<Contact>> get() = _contacts

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _errorMessage = MutableLiveData<String?>(null)
    val errorMessage: LiveData<String?> get() = _errorMessage

    fun getContacts(contact: Context) {
        viewModelScope.launch {
            _errorMessage.value = null
            _isLoading.value = true
            try {

                val jsonFileString = getJsonDataFromAsset(contact, "data.json")
                if (jsonFileString != null) {
                    Log.i("data", jsonFileString)
                }

                val gson = Gson()
                val listPersonType = object : TypeToken<List<Contact>>() {}.type

                var persons: List<Contact> = gson.fromJson(jsonFileString, listPersonType)
                persons.forEachIndexed { idx, person -> Log.i("data", "> Item $idx:\n$person") }

                _contacts.value = persons
            } catch (e: Exception) {
                _errorMessage.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}