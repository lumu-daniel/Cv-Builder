package com.ktn.cvbuilder.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ktn.cvbuilder.ui.fragments.HolderFragment
import javax.inject.Inject


class SectionsPagerAdapter @Inject constructor(
    private val context: Context
) : FragmentStateAdapter((context as AppCompatActivity).supportFragmentManager,context.lifecycle) {

    private val fragments = HolderFragment.fragmentList().map { it.fragment }

    override fun getItemCount(): Int {
      return  fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }


}