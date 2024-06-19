package com.nhoang.marsrover.ui.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.nhoang.marsrover.domain.model.RoverPhotoUiState
import com.nhoang.marsrover.ui.photolist.MarsRoverPhotoViewModel

@Composable
fun PhotoScreen(
    modifier: Modifier,
    roverName: String?,
    sol: String?,
    marsRoverPhotoViewModel: MarsRoverPhotoViewModel
) {
    val viewState by marsRoverPhotoViewModel.roverPhotoUiState.collectAsStateWithLifecycle()

    if (roverName != null && sol != null) {
        LaunchedEffect(Unit) {
            marsRoverPhotoViewModel.getMarsRoverPhoto(roverName, sol)
        }
        when (val roverPhotoUiState = viewState) {
            RoverPhotoUiState.Error -> Error()
            RoverPhotoUiState.Loading -> Loading()
            is RoverPhotoUiState.Success -> PhotoList(
                modifier = modifier,
                roverPhotoUiModelList = roverPhotoUiState.roverPhotoUiModelList)
        }
    }
}