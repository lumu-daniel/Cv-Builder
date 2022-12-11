package com.ktn.cvbuilder.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import com.ktn.cvbuilder.R
import com.ktn.cvbuilder.ui.fragments.adapters.SectionsPagerAdapter
import kotlinx.android.synthetic.main.fragment_holder.*

class HolderFragment constructor(
    private val sectionsPagerAdapter: SectionsPagerAdapter
    ) : Fragment(R.layout.fragment_holder) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view_pager.apply {
            adapter = sectionsPagerAdapter
        }
        tabs.apply {
            TabLayoutMediator(tabs, view_pager) { tab, position ->
                tab.text = sectionsPagerAdapter.fragmentList[position].fragmentTitle
            }.attach()
        }
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    data class FragmentInfo(
        val fragmentTitle:String = "",
        val fragment:Fragment
    )
}