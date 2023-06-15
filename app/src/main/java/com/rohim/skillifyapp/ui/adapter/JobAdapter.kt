package com.rohim.skillifyapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rohim.skillifyapp.data.model.JobEntity
import com.rohim.skillifyapp.databinding.ItemJobBinding

class JobAdapter(private val jobList: ArrayList<JobEntity>, val listener: (JobEntity) -> Unit):
    RecyclerView.Adapter<JobAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: ItemJobBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindView(job: JobEntity, listener: (JobEntity) -> Unit) {
            binding.apply {
                imCompany1.setImageResource(job.imageCompany)
                tvTitleCompany1.text = job.jobTitle
                tvOffice1.text = job.companyName
                tvLocOffice1.text = job.address
            }
            itemView.setOnClickListener {
                listener(job)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val jobBinding = ItemJobBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ListViewHolder(jobBinding)
    }

    override fun getItemCount(): Int = jobList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
//        val (image, title, office, location) = jobList[position]
        holder.bindView(jobList[position], listener)

        val currentItem = jobList[position]
        holder.binding.imCompany1.setImageResource(currentItem.imageCompany)
        holder.binding.tvTitleCompany1.text = currentItem.jobTitle
        holder.binding.tvOffice1.text = currentItem.companyName
        holder.binding.tvLocOffice1.text = currentItem.address
    }
}