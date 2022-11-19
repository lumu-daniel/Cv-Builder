package com.ktn.cvbuilder.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ktn.cvbuilder.R
import com.ktn.cvbuilder.ui.CvViewModel
import javax.inject.Inject

class AboutMeFragment :Fragment(R.layout.fragment_about_me) {

    @Inject
    lateinit var cvViewModel: CvViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}