package com.ktn.cvbuilder.ui.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.ktn.cvbuilder.R
import com.ktn.cvbuilder.data.Certification
import kotlinx.android.synthetic.main.item_certification.view.*
import javax.inject.Inject

class CertificationAdapter @Inject constructor(
    val glide: RequestManager
):RecyclerView.Adapter<CertificationAdapter.CertificationViewHolder>() {

    class CertificationViewHolder(itemView:View):ViewHolder(itemView)

    private val itemCallback = object: ItemCallback<Certification>() {
        override fun areItemsTheSame(oldItem: Certification, newItem: Certification): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Certification, newItem: Certification): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer<Certification>(this,itemCallback)

    var certifications: List<Certification>?
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CertificationViewHolder {
        return CertificationViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_certification,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return certifications!!.size
    }

    override fun onBindViewHolder(holder: CertificationViewHolder, position: Int) {
        val certification = certifications!![position]
        holder.itemView.apply {
            glide.load(certification.certificationImage).into(iv_certification_image)
            tv_certificate_name.text = certification.certificationName
        }
    }
}