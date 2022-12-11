package com.ktn.cvbuilder.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ktn.cvbuilder.R
import com.ktn.cvbuilder.ui.cvViewModel.CvViewModel
import com.ktn.cvbuilder.ui.fragments.adapters.CertificationAdapter
import com.ktn.cvbuilder.ui.fragments.adapters.EducationAdapter
import kotlinx.android.synthetic.main.fragment_about_me.*

class AboutMeFragment constructor(
    private val educationAdapter: EducationAdapter,
    private val certificationAdapter: CertificationAdapter
) :Fragment(R.layout.fragment_about_me) {

    lateinit var cvViewModel: CvViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cvViewModel = ViewModelProvider(requireActivity())[CvViewModel::class.java]
        cvViewModel.cvDto.observe(requireActivity()){cv->
            run{
                certificationAdapter.certifications = cv.certifications
                educationAdapter.educations = cv.educations
            }
        }
        rv_certification_list.apply {
            adapter = certificationAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        rv_education_list.apply {
            adapter = educationAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}