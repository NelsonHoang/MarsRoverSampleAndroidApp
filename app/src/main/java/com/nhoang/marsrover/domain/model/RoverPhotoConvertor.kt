package com.nhoang.marsrover.domain.model

import com.nhoang.marsrover.db.MarsRoverSavedLocalModel

fun toDbModel(roverPhotoUiModel: RoverPhotoUiModel) : MarsRoverSavedLocalModel =
    MarsRoverSavedLocalModel(
        roverPhotoId = roverPhotoUiModel.id,
        roverName = roverPhotoUiModel.roverName,
        imgSrc = roverPhotoUiModel.imgSrc,
        sol = roverPhotoUiModel.sol,
        earthDate = roverPhotoUiModel.earthDate,
        cameraFullName = roverPhotoUiModel.cameraFullName
    )