package com.ktn.cvbuilder.domain.states

import com.facebook.FacebookException
import com.facebook.login.LoginResult

data class FaceBookLoginState(
    var onCancel: Boolean = false,
    var error: FacebookException? = null,
    var result: LoginResult? = null
)
