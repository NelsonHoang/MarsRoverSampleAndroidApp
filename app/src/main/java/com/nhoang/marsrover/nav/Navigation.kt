package com.nhoang.marsrover.nav

import androidx.navigation.NavController
import com.nhoang.marsrover.nav.Destination.HOME

object Destination {
    const val HOME = "home"
    const val MANIFEST = "manifest/{roverName}"
    const val PHOTO = "photo/{roverName}?sol={sol}"
}

class Action(navController: NavController) {
    val home: () -> Unit = { navController.navigate(HOME) }
    val manifest: (roverName: String) -> Unit =
        { roverName ->
            navController.navigate("manifest/${roverName}")
        }
    val photo: (roverName: String, sol: String) -> Unit =
        { roverName, sol ->
            navController.navigate("photo/${roverName}?sol=${sol}")
        }
}