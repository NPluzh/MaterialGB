package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.BuildConfig
import com.example.myapplication.model.PictureOfTheDayResponseData
import com.example.myapplication.model.RepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.IllegalStateException

class PictureOfTheDayviewModel(private val liveData: MutableLiveData<AppState> = MutableLiveData(), private val repositoryImpl: RepositoryImpl = RepositoryImpl()):ViewModel() {
    fun sentRequest(){
        liveData.postValue(AppState.Loading)
        repositoryImpl.getPictureOfTheDayApi().getPictureOfTheDay(BuildConfig.NASA_API_KEY).enqueue(callback)

    }

    fun getLiveData():MutableLiveData<AppState>{
        return liveData
    }

    private val callback = object : Callback<PictureOfTheDayResponseData>{
        override fun onResponse(
            call: Call<PictureOfTheDayResponseData>,
            response: Response<PictureOfTheDayResponseData>
        ) {
            if(response.isSuccessful){
                liveData.postValue(AppState.Success(response.body()!!))
            }else{
                liveData.postValue(AppState.Error(throw IllegalStateException("что-то не так")))
            }

        }

        override fun onFailure(call: Call<PictureOfTheDayResponseData>, t: Throwable) {
            //TODO("Not yet implemented")
        }

    }
}