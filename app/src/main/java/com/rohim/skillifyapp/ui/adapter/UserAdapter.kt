package com.rohim.skillifyapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rohim.skillifyapp.data.model.DummyData
import com.rohim.skillifyapp.databinding.ItemUserBinding

class UserAdapter(private val userList: ArrayList<DummyData>, val listener: (DummyData) -> Unit):
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    class UserViewHolder(var binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindView(user: DummyData, listener: (DummyData) -> Unit) {
            binding.apply {
                imUser1.setImageResource(user.imageUser)
                tvName1.text = user.fullName
                tvNameCompanyUser.text = user.nameCompanyUser
            }
            itemView.setOnClickListener {
                listener(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val userBinding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return UserViewHolder(userBinding)
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindView(userList[position], listener)

        val currentItem = userList[position]
        holder.binding.apply {
            imUser1.setImageResource(currentItem.imageUser)
            tvName1.text = currentItem.fullName
            tvNameCompanyUser.text = currentItem.nameCompanyUser
        }
    }
}