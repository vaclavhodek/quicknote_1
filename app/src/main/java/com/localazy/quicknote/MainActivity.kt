package com.localazy.quicknote

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.platform.setContent
import com.localazy.quicknote.notes.NotesViewModel
import com.localazy.quicknote.ui.AddNote
import com.localazy.quicknote.ui.ShowNotes

class MainActivity : AppCompatActivity() {

    private val notesViewModel by viewModels<NotesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {

                AddNote(getString(R.string.add_note)) {
                    notesViewModel.addNote(it)
                }

                ShowNotes(notesViewModel.notes) {
                    notesViewModel.removeNote(it)
                }

            }
        }
    }

}
