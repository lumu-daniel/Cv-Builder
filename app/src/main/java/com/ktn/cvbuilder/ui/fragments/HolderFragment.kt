package com.ktn.cvbuilder.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import com.ktn.cvbuilder.R
import com.ktn.cvbuilder.ui.CvViewModel
import com.ktn.cvbuilder.ui.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class HolderFragment : Fragment(R.layout.fragment_holder) {

    @Inject
    lateinit var sectionsPagerAdapter: SectionsPagerAdapter

    private lateinit var cvViewModel: CvViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view_pager.apply {
            adapter = sectionsPagerAdapter
        }
        tabs.apply {
            TabLayoutMediator(tabs, view_pager) { tab, position ->
                tab.text = fragmentList()[position].fragmentTitle
            }.attach()
        }
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    companion object{
        fun fragmentList()= listOf<FragmentInfo>(
            FragmentInfo("Home",HomeFragment()),
            FragmentInfo("About Me",AboutMeFragment()),
            FragmentInfo("Work",WorkFragment()),
            FragmentInfo("Contact",ContactFragment())
        )
    }

    data class FragmentInfo(
        val fragmentTitle:String = "",
        val fragment:Fragment
    )
}