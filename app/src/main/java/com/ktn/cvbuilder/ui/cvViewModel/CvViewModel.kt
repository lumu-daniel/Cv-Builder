package com.ktn.cvbuilder.ui.cvViewModel

import android.app.Activity
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.ktn.cvbuilder.data.CvDto
import com.ktn.cvbuilder.data.local.LocalDataAccessApi
import com.ktn.cvbuilder.data.local.room.entities.UserTable
import com.ktn.cvbuilder.domain.states.AddItemState
import com.ktn.cvbuilder.domain.states.FaceBookLoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CvViewModel @Inject constructor(
    private val localDataAccessApi: LocalDataAccessApi
): ViewModel() {

    private val _cvDto = MutableLiveData<CvDto>()
    val cvDto:LiveData<CvDto> = _cvDto

    private val _fbLoginState = MutableLiveData<FaceBookLoginState>()
    val fbLoginState: LiveData<FaceBookLoginState> = _fbLoginState

    private val _addItem = MutableLiveData<AddItemState>()
    val addItem:LiveData<AddItemState> = _addItem

    fun setCvDto(value: CvDto){
        _cvDto.postValue(value)
    }

    fun createUser(userName:String, password:String){
        viewModelScope.launch {
            localDataAccessApi.insertUser(UserTable(userName,password))
            _cvDto.value = _cvDto.value?.copy(name = userName, password = password)
        }
    }

    fun loginWithFacebook(activity: Activity){

        val callbackManager = CallbackManager.Factory.create()
        val loginManager = LoginManager.getInstance()
        loginManager.logInWithReadPermissions(activity, listOf("email"))
        loginManager.registerCallback(callbackManager, object: FacebookCallback<LoginResult> {
            override fun onCancel() {
                Log.e("FB", "cancel")
                _fbLoginState.value?.onCancel =true
            }

            override fun onError(error: FacebookException) {
                Log.e("FB", "Error")
                _fbLoginState.value?.error = error
            }

            override fun onSuccess(result: LoginResult) {
                Log.e("FB", result.toString())
                _fbLoginState.value?.result = result
            }

        })
    }

    fun setAddItem(dialogTitle:String, titleHint:String, contentHint:String ){
        _addItem.value = AddItemState(
            dialogTitle = dialogTitle,
            addHint = titleHint,
            contentHint = contentHint
        )
    }
}