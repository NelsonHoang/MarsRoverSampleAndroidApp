package com.nhoang.marsrover.ui.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.nhoang.marsrover.domain.model.RoverPhotoUiState
import com.nhoang.marsrover.ui.savedlist.MarsRoverSavedViewModel

@Composable
fun PhotoListSavedScreen(
    modifier: Modifier,
    marsRoverSavedViewModel: MarsRoverSavedViewModel
) {
    val viewState by marsRoverSavedViewModel.marsPhotoUiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        marsRoverSavedViewModel.getAllSaved()
    }

    when(val roverPhotoUiState = viewState) {
        RoverPhotoUiState.Error -> Error()
        RoverPhotoUiState.Loading -> Loading()
        is RoverPhotoUiState.Success -> PhotoList(
            modifier = modifier,
            roverPhotoUiModelList = roverPhotoUiState.roverPhotoUiModelList,
            onClick = {roverPhotoUiModel ->
                marsRoverSavedViewModel.changeSavedStatus(roverPhotoUiModel)
            }
        )
    }
}