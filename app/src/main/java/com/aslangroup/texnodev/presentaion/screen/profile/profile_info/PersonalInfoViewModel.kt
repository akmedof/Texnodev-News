package com.aslangroup.texnodev.presentaion.screen.profile.profile_info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aslangroup.texnodev.domain.model.user.PersonalData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersonalInfoViewModel @Inject constructor() : ViewModel() {

    private val _data = MutableLiveData(PersonalData())
    val data:LiveData<PersonalData> get() = _data

    fun updatePersonalData(data: PersonalData){
        _data.value = data
    }


}