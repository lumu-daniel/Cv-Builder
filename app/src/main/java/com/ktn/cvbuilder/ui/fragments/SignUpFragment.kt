package com.ktn.cvbuilder.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ktn.cvbuilder.R
import com.ktn.cvbuilder.ui.cvViewModel.CvViewModel
import kotlinx.android.synthetic.main.fragment_signup.*

class SignUpFragment: Fragment(R.layout.fragment_signup) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(requireActivity())[CvViewModel::class.java]
        signUpBtn.apply {
            setOnClickListener{
                val _userName = username.text.toString()
                val _password = password.text.toString()
                val _reTypePassword = reTypePassword.text.toString()
                if(_userName.isEmpty()){
                    username.error = "Please Enter Username"
                }else if(_password.isEmpty()){
                    password.error = "Please Enter Password"
                }else if(_reTypePassword.isEmpty()){
                    reTypePassword.error = "Please Retype Password"
                }else{
                    if(_password == _reTypePassword){
                        viewModel.createUser(_userName, _password)
                        findNavController().navigate(
                            SignUpFragmentDirections.actionSignUpFragmentToLoginFragment()
                        )
                    }else{
                        password.error = "Passwords are not equal"
                        reTypePassword.error = "Passwords are not equal"
                    }
                }
            }
        }
    }
}