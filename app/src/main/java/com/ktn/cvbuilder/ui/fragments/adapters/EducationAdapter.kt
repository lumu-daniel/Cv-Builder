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
import com.ktn.cvbuilder.data.Education
import kotlinx.android.synthetic.main.item_education.view.*
import javax.inject.Inject

class EducationAdapter @Inject constructor(
    private val glide: RequestManager
):RecyclerView.Adapter<EducationAdapter.EducationViewHolder>() {

    class EducationViewHolder(itemView: View): ViewHolder(itemView)

    private val itemCallback = object: ItemCallback<Education>(){
        override fun areItemsTheSame(oldItem: Education, newItem: Education): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: Education, newItem: Education): Boolean {
            return oldItem==newItem
        }
    }

    private val differ = AsyncListDiffer<Education>(this,itemCallback)

    var educations: List<Education>?
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationViewHolder {
        return EducationViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_education,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return educations!!.size
    }

    override fun onBindViewHolder(holder: EducationViewHolder, position: Int) {
        val education = educations!![position]
        holder.itemView.apply {
            glide.load(education.collageImage).into(iv_college_badge)
            tv_collage_name.text = education.collegeName
            tv_degree_type.text = education.major
        }
    }
}