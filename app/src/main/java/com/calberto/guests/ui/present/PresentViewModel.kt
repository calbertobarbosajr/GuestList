package com.calberto.guests.ui.present

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.calberto.guests.service.model.GuestModel
import com.calberto.guests.service.repository.GuestRepository


// class PresentViewModel : ViewModel() {
class PresentViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application.applicationContext)

    private val _guestList = MutableLiveData<List<GuestModel>>()
    val guestList: LiveData<List<GuestModel>> = _guestList

    fun delete(id: Int) {
        repository.delete(id)
    }

    fun getPresent() {
        _guestList.value = repository.getPresent()
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is slideshow Fragment"
    }
    val text: LiveData<String> = _text
}