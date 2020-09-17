package com.localazy.quicknote.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.localazy.quicknote.AppDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    private val db = Room.databaseBuilder(
        application.applicationContext,
        AppDatabase::class.java,
        "db-notes"
    ).build()

    var notes by mutableStateOf(listOf<Note>())
        private set

    // Load initial data from Room asynchronously.
    init {
        GlobalScope.launch {
            val items = db.notes().getAll()
            viewModelScope.launch { notes = items }
        }
    }

    fun addNote(note: String) {
        // Generate ID in a simple way - from timestamp.
        val noteObj = Note((System.currentTimeMillis() % Int.MAX_VALUE).toInt(), note)
        notes = notes + listOf(noteObj)
        GlobalScope.launch { db.notes().insert(noteObj) }
    }

    fun removeNote(note: Note) {
        notes = notes - listOf(note)
        GlobalScope.launch { db.notes().delete(note) }
    }

}