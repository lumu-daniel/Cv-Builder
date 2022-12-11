package com.ktn.cvbuilder.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ktn.cvbuilder.R
import com.ktn.cvbuilder.ui.cvViewModel.CvViewModel
import com.ktn.cvbuilder.ui.fragments.adapters.ContactsAdapter
import kotlinx.android.synthetic.main.fragment_contact.*

class ContactFragment constructor(
    private val contactsAdapter: ContactsAdapter
    ) :Fragment(R.layout.fragment_contact) {

    lateinit var cvViewModel: CvViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cvViewModel = ViewModelProvider(requireActivity())[CvViewModel::class.java]
        cvViewModel.cvDto.observe(requireActivity()){
            contactsAdapter.contacts = it.contacts
        }
        rv_contactList.apply {
            adapter = contactsAdapter
            layoutManager = LinearLayoutManager(requireContext())

        }
    }
}