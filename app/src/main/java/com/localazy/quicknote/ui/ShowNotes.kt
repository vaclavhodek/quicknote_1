package com.localazy.quicknote.ui

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.InnerPadding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.localazy.quicknote.notes.Note

@Composable
fun ShowNotes(items: List<Note>, onNodeRemoved: (Note) -> Unit) {
    LazyColumnFor(items = items) {
        Row {
            Text(
              text = it.content,
              modifier = Modifier
                .padding(16.dp, 4.dp, 4.dp, 4.dp)
                .weight(1f, true)
                .gravity(Alignment.CenterVertically)
            )
            TextButton(
              onClick = {
                onNodeRemoved(it)
              },
              contentPadding = InnerPadding(0.dp),
              modifier = Modifier
                .padding(4.dp, 4.dp, 16.dp, 4.dp)
                .gravity(Alignment.CenterVertically)
            ) {
                Icon(
                  asset = Icons.Filled.Delete,
                  modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}