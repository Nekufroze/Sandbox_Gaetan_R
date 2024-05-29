package org.mathieu.sandbox.ui.screens.episodedetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController


@Composable
fun EpisodeDetailsScreen(
    navController: NavController,
    episodeId: Int
) {
    val viewModel: EpisodeDetailsViewModel = viewModel()
    val state: CharacterDetailsState by viewModel.state.collectAsState()

    LaunchedEffect(key1 = 0) {
        viewModel.initialize(episodeId = episodeId)
    }

    MaterialTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Content(state = state)
        }
    }
}

@Composable
private fun Content(state: CharacterDetailsState) = Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
) {
    Text(
        text = state.date,
        modifier = Modifier.padding(bottom = 8.dp),
        style = MaterialTheme.typography.titleMedium,
    )
    Text(
        text = state.name,
        modifier = Modifier.padding(bottom = 16.dp),
        style = MaterialTheme.typography.titleLarge,
    )

}