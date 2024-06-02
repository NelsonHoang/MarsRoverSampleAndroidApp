package com.nhoang.marsrover.nav

import androidx.navigation.NavController
import com.nhoang.marsrover.nav.Destination.HOME

object Destination {
    const val HOME = "home"
    const val MANIFEST = "manifest/{roverName}"
}

class Action(navController: NavController) {
    val home: () -> Unit = { navController.navigate(HOME) }
    val manifest: (roverName: String) -> Unit =
        { roverName ->
            navController.navigate("manifest/${roverName}")
        }
}