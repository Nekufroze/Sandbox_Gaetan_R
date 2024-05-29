package org.mathieu.sandbox.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CharacterCard(
    name: String,
    surname: String,
    onClick: () -> Unit
) = Card(
    modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable(onClick = onClick)
) {
    Column(
        modifier = Modifier.padding(8.dp),
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.labelSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = surname,
            style = MaterialTheme.typography.labelLarge
        )
    }
}