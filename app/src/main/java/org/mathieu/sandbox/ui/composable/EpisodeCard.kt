package org.mathieu.sandbox.ui.composable

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.mathieu.sandbox.Utils.playSoundAndVibrate
import org.mathieu.sandbox.domain.models.Episode
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun EpisodeCard(
    episode: Episode,
    onClick: () -> Unit,
    context: Context
) {

    // Convert the input date to the US format.
    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    // Convert the date to the output format.
    val outputFormat = SimpleDateFormat("MMMM dd, yyyy", Locale.US)

    val parsedDate = inputFormat.parse(episode.date)
    val formattedDate = parsedDate?.let { outputFormat.format(it) }


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                onClick()
                playSoundAndVibrate(context)
            },
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
        ) {
            if (formattedDate != null) {
                Text(
                    text = formattedDate,
                    style = MaterialTheme.typography.labelSmall
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = episode.name,
                style = MaterialTheme.typography.labelLarge

            )
        }
    }
}