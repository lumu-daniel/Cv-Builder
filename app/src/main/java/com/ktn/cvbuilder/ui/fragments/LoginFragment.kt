package com.ktn.cvbuilder.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.facebook.CallbackManager
import com.facebook.login.LoginResult
import com.ktn.cvbuilder.R
import com.ktn.cvbuilder.ui.cvViewModel.CvViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(R.layout.fragment_login) {

    lateinit var loginResult:LoginResult
    lateinit var callbackManager: CallbackManager
    private val viewModel by lazy {
        ViewModelProvider(this)[CvViewModel::class.java]
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginFacebookButton.apply {
            setOnClickListener{
                viewModel.loginWithFacebook(requireActivity())
                viewModel.fbLoginState.observe(requireActivity()){
                    loginResult = it.result!!
                }
            }
        }
    }

}