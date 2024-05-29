package org.mathieu.sandbox.data

import org.mathieu.sandbox.domain.models.Character
import org.mathieu.sandbox.domain.models.Episode

object CharacterLocal {
    var characters: MutableList<Character> = mutableListOf(
        Character(
            id = 1,
            firstName = "John",
            lastName = "Snow",
            age = 20,
            episodes = listOf(
                Episode(
                    1,
                    date = "2011-04-17",
                    name = "S01 - E1 : Winter is coming"
                ),
                Episode(
                    2,
                    date = "2011-04-24",
                    name = "The Kingsroad"
                )
            )
        ),
        Character(
            id = 2,
            firstName = "Jack",
            lastName = "Sparrow",
            age = 21,
            episodes = listOf(
                Episode(
                    id = 3,
                    date = "2003-07-09",
                    name = "The Curse of the Black Pearl"
                ),
                Episode(
                    id = 4,
                    date = "2003-07-06",
                    name = "Dead Man's Chest"
                )
            )
        ),
        Character(
            id = 3,
            firstName = "Rick",
            lastName = "Sanchez",
            age = 22,
            episodes = listOf(
                Episode(
                    5,
                    date = "2013-12-02",
                    name = "Pilot"
                ),
                Episode(
                    6,
                    date = "2013-12-09",
                    name = "Lawnmower Dog"
                )
            )
        )
    )
}