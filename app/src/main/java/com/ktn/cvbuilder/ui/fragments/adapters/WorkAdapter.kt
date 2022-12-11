package com.ktn.cvbuilder.ui.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.ktn.cvbuilder.R
import com.ktn.cvbuilder.data.Work
import kotlinx.android.synthetic.main.item_experience.view.*
import javax.inject.Inject

class WorkAdapter @Inject constructor(
    private val glide:RequestManager
): Adapter<WorkAdapter.WorkHolder>() {

    class WorkHolder(itemView: View): ViewHolder(itemView)

    private val callback = object: ItemCallback<Work>(){
        override fun areItemsTheSame(oldItem: Work, newItem: Work): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: Work, newItem: Work): Boolean {
            return oldItem==newItem
        }

    }

    private val differ = AsyncListDiffer(this, callback)

    var works: List<Work>?
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkHolder {
        return WorkHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_experience, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return works!!.size
    }

    override fun onBindViewHolder(holder: WorkHolder, position: Int) {
        val work = works!![position]
        holder.itemView.apply {
            glide.load(work.workImage).into(iv_experience)
            tv_experience_role.text = work.job
            tv_experience_company.text = work.companyName
            tv_time_line.text = "${work.from}-${work.to}"
            tv_location.text = "${work.city}, ${work.state}"
            tv_role_desc.text = work.desc
        }
    }
}