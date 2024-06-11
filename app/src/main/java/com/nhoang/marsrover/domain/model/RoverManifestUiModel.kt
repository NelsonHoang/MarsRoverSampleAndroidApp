package com.nhoang.marsrover.domain.model

import com.nhoang.marsrover.service.model.RoverManifestRemoteModel

sealed class RoverManifestUiState {
    data class Success(
        val roverManifestUiModel: List<RoverManifestUiModel>
    ) : RoverManifestUiState()
    data object Loading : RoverManifestUiState()
    data object Error: RoverManifestUiState()
}

data class RoverManifestUiModel(
    val sol: String,
    val earthDate: String,
    val photoNumber: String
) : Comparable<RoverManifestUiModel> {
    override fun compareTo(other: RoverManifestUiModel): Int =
        other.earthDate.compareTo(this.earthDate)
}