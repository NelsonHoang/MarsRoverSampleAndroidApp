package com.nhoang.marsrover.ui.photolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nhoang.marsrover.data.MarsRoverPhotoRepo
import com.nhoang.marsrover.domain.model.RoverPhotoUiModel
import com.nhoang.marsrover.domain.model.RoverPhotoUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarsRoverPhotoViewModel @Inject constructor(
    private val marsRoverPhotoRepo: MarsRoverPhotoRepo
) : ViewModel() {

    private val _roverPhotoUiState: MutableStateFlow<RoverPhotoUiState> =
        MutableStateFlow(RoverPhotoUiState.Loading)

    val roverPhotoUiState: StateFlow<RoverPhotoUiState>
        get() = _roverPhotoUiState

    fun getMarsRoverPhoto(roverName: String, sol: String) {
        viewModelScope.launch {
            _roverPhotoUiState.value = RoverPhotoUiState.Loading
            marsRoverPhotoRepo.getMarsRoverPhoto(roverName, sol).collect {
                _roverPhotoUiState.value = it
            }
        }
    }

    fun changeSavedStatus(roverPhotoUiModel: RoverPhotoUiModel) {
        viewModelScope.launch(Dispatchers.IO) {
            if (roverPhotoUiModel.isSaved) {
                marsRoverPhotoRepo.removePhoto(roverPhotoUiModel)
            } else {
                marsRoverPhotoRepo.savePhoto(roverPhotoUiModel)
            }
        }
    }
}