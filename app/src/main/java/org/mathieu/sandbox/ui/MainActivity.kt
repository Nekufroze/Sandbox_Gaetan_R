package org.mathieu.sandbox.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.mathieu.sandbox.ui.core.theme.SandboxTheme
import org.mathieu.sandbox.ui.screens.characterdetails.CharacterDetailsScreen
import org.mathieu.sandbox.ui.screens.characters.CharactersScreen
import org.mathieu.sandbox.ui.screens.episodedetails.EpisodeDetailsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val navController = rememberNavController()

            SandboxTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //https://developer.android.com/develop/ui/compose/navigation?hl=fr
                    NavHost(
                        startDestination = "characters",
                        navController = navController
                    ) {
                        composable(route = "characters") {
                            CharactersScreen(
                                navController = navController
                            )
                        }
                        composable(
                            route = "characters/{id}",
                            arguments = listOf(navArgument("id") { type = NavType.IntType })
                        ) { navBackStackEntry ->
                            val id: Int? = navBackStackEntry.arguments?.getInt("id")


                            if (id != null) {
                                CharacterDetailsScreen(
                                    context = this@MainActivity,
                                    navController = navController,
                                    characterId = id
                                )
                            } else {
                                LaunchedEffect(key1 = Unit) {
                                    navController.popBackStack()
                                }
                            }
                        }
                        composable(
                            route = "episodes/{id}",
                            arguments = listOf(navArgument("id") { type = NavType.IntType })
                        ) { navBackStackEntry ->
                            val id: Int? = navBackStackEntry.arguments?.getInt("id")

                            if (id != null) {
                                EpisodeDetailsScreen(
                                    navController = navController,
                                    episodeId = id
                                )
                            } else {
                                LaunchedEffect(key1 = Unit) {
                                    navController.popBackStack()
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}
