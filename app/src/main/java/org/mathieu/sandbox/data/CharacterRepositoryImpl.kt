package org.mathieu.sandbox.data

import org.mathieu.sandbox.domain.models.Character
import org.mathieu.sandbox.domain.models.Episode
import org.mathieu.sandbox.domain.repositories.ICharacterRepository

object CharacterRepositoryImpl : ICharacterRepository {

    /**
     * Try to retrieve a character, using its id. If there is no character found, then it returns null.
     *
     * @param id The id of the character that we are looking for
     * @return It returns either a [Character] or null if not found.
     */
    override fun getCharacterByIdOrNull(id: Int): Character? {

        return CharacterLocal.characters.find { character ->
            character.id == id
        }

    }
    
    /**
     * Retrieves all characters from the local data source.
     *
     * @return A list of [Character] objects.
     */
    override fun getCharacters() = CharacterLocal.characters


    /**
     * Try to retrieve an episode, using its id. If there is no episode found, then it returns null.
     *
     * @param id The id of the episode that we are looking for
     * @return It returns either an [Episode] or null if not found.
     */
    override fun getEpisodeByIdOrNull(id: Int): Episode? {

        return CharacterLocal.characters.flatMap { character ->
            character.episodes
        }.find { episode ->
            episode.id == id
        }
    }
}