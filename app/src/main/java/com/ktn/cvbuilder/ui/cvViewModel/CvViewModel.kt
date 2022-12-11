package com.ktn.cvbuilder.ui.cvViewModel

import android.app.Activity
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.ktn.cvbuilder.data.CvDto

class CvViewModel : ViewModel() {

    private val _cvDto = MutableLiveData<CvDto>()
    val cvDto:LiveData<CvDto> = _cvDto

    private val _fbLoginState = MutableLiveData<FaceBookLoginState>()
    val fbLoginState: LiveData<FaceBookLoginState> = _fbLoginState

    fun setCvDto(value: CvDto){
        _cvDto.postValue(value)
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
}