package com.ktn.cvbuilder.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ktn.cvbuilder.data.CvDto

class CvViewModel : ViewModel() {

    private val _cvDto = MutableLiveData<CvDto>()
    val cvDto:LiveData<CvDto> = _cvDto

    fun setCvDto(value: CvDto){
        _cvDto.postValue(value)
    }

}