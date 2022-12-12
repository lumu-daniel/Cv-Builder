package com.ktn.cvbuilder.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.ktn.cvbuilder.R
import com.ktn.cvbuilder.ui.cvViewModel.CvViewModel
import com.ktn.cvbuilder.ui.fragments.adapters.SectionsPagerAdapter
import kotlinx.android.synthetic.main.fragment_holder.*

class HolderFragment constructor(
    private val sectionsPagerAdapter: SectionsPagerAdapter
    ) : Fragment(R.layout.fragment_holder) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(requireActivity())[CvViewModel::class.java]
        view_pager.apply {
            adapter = sectionsPagerAdapter
        }
        tabs.apply {
            TabLayoutMediator(tabs, view_pager) { tab, position ->
                tab.text = sectionsPagerAdapter.fragmentList[position].fragmentTitle
            }.attach()
        }
        fab.setOnClickListener { view ->
            when(tabs.selectedTabPosition){
                0 -> {
                    viewModel.setAddItem("Add note","Note Title", "Note")
                    AddDialog().show(requireActivity().supportFragmentManager,"")
                }
                1 ->{
                    viewModel.setAddItem("Add Education/Certification","Note Title", "Note")
                    AddDialog().show(requireActivity().supportFragmentManager,"")
                }
                2->{
                    viewModel.setAddItem("Add Work","Work Title", "Work Position")
                    AddDialog().show(requireActivity().supportFragmentManager,"")
                }
                3 ->{
                    viewModel.setAddItem("Add Contact","Contact Type", "Contact Value")
                    AddDialog().show(requireActivity().supportFragmentManager,"")
                }
            }
        }
    }

    data class FragmentInfo(
        val fragmentTitle:String = "",
        val fragment:Fragment
    )
}