package com.tecsup.edu.lab9_room.informations

import android.app.Application
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.edu.lab9_room.R
import kotlinx.coroutines.launch

class InformationViewModel(application: Application): AndroidViewModel(application){

    private val repository = InformationRepository(application)

    val informations = repository.getNotes()

    fun saveInformations(information: Information) {
        viewModelScope.launch {
            repository.insertNoteWithCoroutines(information)
        }
    }


}