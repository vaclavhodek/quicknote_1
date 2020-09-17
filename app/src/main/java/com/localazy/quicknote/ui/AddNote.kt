package com.localazy.quicknote.ui

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun AddNote(title: String, onNoteAdded: (String) -> Unit) {
    Row {
        val text = remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = text.value,
            onValueChange = { text.value = it },
            label = { Text(title) },
            modifier = Modifier
                .weight(1f, true)
                .padding(16.dp, 16.dp, 8.dp, 16.dp)
        )
        Button(
            onClick = {
                val newNote = text.value.text
                if (newNote.isNotBlank()) {
                    onNoteAdded(newNote)
                    text.value = TextFieldValue("")
                }
            },
            modifier = Modifier
                .padding(8.dp, 16.dp, 16.dp, 16.dp)
                .gravity(Alignment.CenterVertically)
        ) {
            Icon(
                asset = Icons.Filled.Add,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
