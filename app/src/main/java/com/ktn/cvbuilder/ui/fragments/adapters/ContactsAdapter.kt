package com.ktn.cvbuilder.ui.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ktn.cvbuilder.R
import com.ktn.cvbuilder.data.Contact
import kotlinx.android.synthetic.main.item_contact.view.*

class ContactsAdapter: Adapter<ContactsAdapter.ContactViewHolder>() {

    class ContactViewHolder (itemView: View): ViewHolder(itemView)

    private val callback = object: ItemCallback<Contact>(){
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer<Contact>(this, callback)

    var contacts: List<Contact>?
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_contact,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return contacts!!.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts!![position]
        holder.itemView.apply {
            iv_mobile.setImageResource(contact.contactIcn)
            contact_value.text = contact.contactValue
            contact_type.text = contact.contactType
        }
    }
}