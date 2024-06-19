package com.nhoang.marsrover.nav

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.navigation.NavController
import com.nhoang.marsrover.R
import com.nhoang.marsrover.nav.Destination.HOME

object Destination {
    const val HOME = "home"
    const val MANIFEST = "manifest/{roverName}"
    const val PHOTO = "photo/{roverName}?sol={sol}"
    const val SAVED = "saved"
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

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    @DrawableRes val drawableId: Int
) {
    data object Home : Screen(route = "home", R.string.rover, R.drawable.ic_mars_rover)
    data object Saved : Screen(route = "saved", R.string.saved, R.drawable.ic_save)
}