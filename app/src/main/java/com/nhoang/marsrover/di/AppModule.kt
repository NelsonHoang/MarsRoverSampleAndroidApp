package com.nhoang.marsrover.di

import android.content.Context
import com.nhoang.marsrover.db.MarsRoverSavedDatabase
import com.nhoang.marsrover.db.MarsRoverSavedPhotoDao
import com.nhoang.marsrover.service.MarsRoverManifestService
import com.nhoang.marsrover.service.MarsRoverPhotoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideMarsRoverManifestService(): MarsRoverManifestService =
        MarsRoverManifestService.create()

    @Provides
    fun provideMarsRoverPhotoService(): MarsRoverPhotoService =
        MarsRoverPhotoService.create()

    @Provides
    fun provideMarsRoverPhotoDao(@ApplicationContext context: Context): MarsRoverSavedPhotoDao =
        MarsRoverSavedDatabase.getInstance(context = context).marsRoverSavedPhotoDao()
}