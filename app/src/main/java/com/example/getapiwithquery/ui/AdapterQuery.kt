package com.example.getapiwithquery.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.getapiwithquery.data.UseridItem
import com.example.getapiwithquery.databinding.UserItemBinding

class AdapterQuery(): RecyclerView.Adapter<AdapterQuery.UserIdViewModel>(){

    private val listItemUser = mutableListOf<UseridItem>()

    class UserIdViewModel(val listUser: UserItemBinding) : RecyclerView.ViewHolder(listUser.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserIdViewModel (
        UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: UserIdViewModel, position: Int) {
       holder.listUser.apply {
           with(listItemUser[position]){
               txtUserId.text = email
           }
       }
    }

    override fun getItemCount() = listItemUser.size

    fun setData(list: List<UseridItem>?){
        if (list == null) return
        this.listItemUser.clear()
        this.listItemUser.addAll(list)
    }
}