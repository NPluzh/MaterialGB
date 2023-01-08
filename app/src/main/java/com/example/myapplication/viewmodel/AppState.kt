package com.example.myapplication.viewmodel

import com.example.myapplication.model.PictureOfTheDayResponseData

sealed class AppState {
    data class Success(val pictureOfTheDayResponseData: PictureOfTheDayResponseData):AppState()
    data class Error(val error: Throwable):AppState()
    object Loading:AppState()
}