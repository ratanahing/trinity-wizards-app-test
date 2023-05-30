package com.trinitywizards.apptest.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trinitywizards.apptest.models.Contact
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _contact = MutableLiveData<Contact>()
    val contact: LiveData<Contact>
        get() = _contact


    fun getContactDetails(contactId: Int) {
        // val api = RetrofitInstance.api
        // Coroutine style
        viewModelScope.launch() {
            _isLoading.value = true
            // val fetchedPost = api.getContact(contactId)
            // val fetchedUser = api.getUser(fetchedPost.userId)
            // _contact.value = fetchedPost
            _isLoading.value = false
        }

    }
}