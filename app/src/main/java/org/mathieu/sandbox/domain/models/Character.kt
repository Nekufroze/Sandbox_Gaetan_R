package org.mathieu.sandbox.domain.models

/**
 * Represents a character
 *
 * @property id unique identifier for the character
 * @property firstName the character's first name
 * @property lastName the character's last name
 * @property age the character's age
 * @property episodes a list of episodes the character appears in
 */
data class Character(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val episodes: List<Episode>
)