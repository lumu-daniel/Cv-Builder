package com.ktn.cvbuilder.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.facebook.CallbackManager
import com.facebook.login.LoginResult
import com.ktn.cvbuilder.R
import com.ktn.cvbuilder.ui.cvViewModel.CvViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(R.layout.fragment_login) {

    lateinit var loginResult:LoginResult
    lateinit var callbackManager: CallbackManager
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(requireActivity())[CvViewModel::class.java]
        username.setText(viewModel.cvDto.value?.name)
        password.setText(viewModel.cvDto.value?.password)
        loginBtn.apply {
            setOnClickListener{
                val _username = username.text.toString()
                val _password = password.text.toString()
                if(_password.isEmpty()){
                    password.error = "Password Cannot be empty"
                }else if(_username.isEmpty()){
                    username.error = "Username cannot be empty"
                }else{
                    findNavController().navigate(
                        LoginFragmentDirections.actionLoginFragmentToHolderFragment()
                    )
                }
            }
        }
        loginFacebookButton.apply {
            setOnClickListener{
                viewModel.loginWithFacebook(requireActivity())
                viewModel.fbLoginState.observe(requireActivity()){
                    loginResult = it.result!!
                }
            }
        }
        createAccount.apply {
            setOnClickListener{
                findNavController().navigate(
                    LoginFragmentDirections.actionLoginFragmentToSignUpFragment()
                )
            }
        }
    }

}