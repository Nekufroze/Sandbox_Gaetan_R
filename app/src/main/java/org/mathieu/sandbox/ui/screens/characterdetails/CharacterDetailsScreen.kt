package org.mathieu.sandbox.ui.screens.characterdetails

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import org.mathieu.sandbox.ui.composable.EpisodeCard

@Composable
fun CharacterDetailsScreen(
    navController: NavController,
    characterId: Int,
    context: Context
) {
    val viewModel: CharacterDetailsViewModel = viewModel()
    val state: CharacterDetailsState by viewModel.state.collectAsState()

    LaunchedEffect(key1 = 0) {
        viewModel.initialize(id = characterId)
    }

    Content(
        context = context,
        state = state,
        clickedOnCard = {
            navController.navigate("episodes/${it}")
        }
    )
}


@Composable
private fun Content(
    context: Context,
    state: CharacterDetailsState,
    clickedOnCard: (Int) -> Unit = { }
) = Column {
    Text(
        text = "${state.firstName} ${state.lastName}",
        modifier = Modifier.padding(8.dp)
    )
    state.episodes.forEach { episode ->
        EpisodeCard(episode = episode, onClick = { clickedOnCard(episode.id) }, context = context)
    }

}
