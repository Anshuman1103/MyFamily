package com.example.myfamily2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MemberAdaptor( private val listMembers: List<MemberModel>) : RecyclerView.Adapter<MemberAdaptor.ViewHolder>() {
    class ViewHolder(private val item:View): RecyclerView.ViewHolder(item) {
        val imageUser = item.findViewById<ImageView>(R.id.profile_pic)
        val name = item.findViewById<TextView>(R.id.name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberAdaptor.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val item = inflater.inflate(R.layout.item_member, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: MemberAdaptor.ViewHolder, position: Int) {

        val item = listMembers[position]
        holder.name.text = item.name
    }

    override fun getItemCount(): Int {
        return listMembers.size
    }
}