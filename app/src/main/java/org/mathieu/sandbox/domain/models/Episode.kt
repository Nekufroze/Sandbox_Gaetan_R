package org.mathieu.sandbox.domain.models


/**
 * Represents a single episode in a TV show or series.
 * @property id unique identifier for the episode
 * @property date the date the episode aired
 * @property name the name of the episode
 */

data class Episode(
    val id: Int,
    val date: String,
    val name: String
)
