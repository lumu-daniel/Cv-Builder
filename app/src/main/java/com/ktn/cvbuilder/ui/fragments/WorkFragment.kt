package com.ktn.cvbuilder.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ktn.cvbuilder.R
import com.ktn.cvbuilder.ui.cvViewModel.CvViewModel
import com.ktn.cvbuilder.ui.fragments.adapters.WorkAdapter
import kotlinx.android.synthetic.main.fragment_work.*

class WorkFragment constructor(
    private val workAdapter: WorkAdapter
):Fragment(R.layout.fragment_work) {

    lateinit var cvViewModel: CvViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cvViewModel = ViewModelProvider(requireActivity())[CvViewModel::class.java]
        cvViewModel.cvDto.observe(requireActivity()){
            workAdapter.works = it.works
        }
        rv_experienceList.apply {
            adapter = workAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}