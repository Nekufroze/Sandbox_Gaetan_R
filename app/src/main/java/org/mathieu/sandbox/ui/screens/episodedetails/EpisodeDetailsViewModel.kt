package org.mathieu.sandbox.ui.screens.episodedetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.mathieu.sandbox.data.CharacterRepositoryImpl
import java.text.SimpleDateFormat
import java.util.Locale

class EpisodeDetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val _state: MutableStateFlow<CharacterDetailsState> =
        MutableStateFlow(CharacterDetailsState())

    val state: StateFlow<CharacterDetailsState>
        get() = _state

    fun initialize(episodeId: Int) {
        // This method is called to initialize the ViewModel with the episode ID.
        // We retrieve the corresponding episode and update his state.

        val episode = CharacterRepositoryImpl.getEpisodeByIdOrNull(episodeId)
        val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val outputFormat = SimpleDateFormat("MMMM dd, yyyy", Locale.US)

        val parsedDate = inputFormat.parse(episode?.date ?: "")
        val formattedDate = parsedDate?.let { outputFormat.format(it) }

        if (episode != null) {
            _state.value = CharacterDetailsState(
                date = formattedDate ?: "",
                name = episode.name,
            )
        }

    }

}


data class CharacterDetailsState(
    val date: String = "",
    val name: String = ""
)