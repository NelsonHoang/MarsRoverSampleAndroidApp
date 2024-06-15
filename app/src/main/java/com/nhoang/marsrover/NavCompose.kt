package com.nhoang.marsrover

import android.provider.ContactsContract.Contacts.Photo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nhoang.marsrover.nav.Action
import com.nhoang.marsrover.nav.Destination.HOME
import com.nhoang.marsrover.nav.Destination.MANIFEST
import com.nhoang.marsrover.nav.Destination.PHOTO
import com.nhoang.marsrover.ui.theme.MarsRoverTheme
import com.nhoang.marsrover.ui.view.ManifestScreen
import com.nhoang.marsrover.ui.view.PhotoScreen
import com.nhoang.marsrover.ui.view.RoverList

@Composable
fun NavCompose() {
    val navController = rememberNavController()
    val actions = remember(navController) { Action(navController) }

    MarsRoverTheme {
        NavHost(navController = navController, startDestination = HOME) {
            composable(HOME) {
                RoverList { roverName ->
                    actions.manifest(roverName)
                }
            }
            composable(MANIFEST) { backStackEntry ->
                ManifestScreen(
                    roverName = backStackEntry.arguments?.getString("roverName"),
                    marsRoverManifestViewModel = hiltViewModel(),
                    onClick = { roverName, sol ->
                        actions.photo(roverName, sol)
                    }
                )
            }
            composable(PHOTO) { backStackEntry ->
                PhotoScreen(
                    roverName = backStackEntry.arguments?.getString("roverName"),
                    sol = backStackEntry.arguments?.getString("sol"),
                    marsRoverPhotoViewModel = hiltViewModel()
                )
            }
        }
    }
}