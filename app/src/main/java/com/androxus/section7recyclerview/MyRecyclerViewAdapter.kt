package com.androxus.section7recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androxus.section7recyclerview.databinding.ItemListBinding

class MyRecyclerViewAdapter(val fruites: List<Fruits>) : RecyclerView.Adapter<MyViewHolder>() {

    private var progress: Int = -100


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val LayoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(LayoutInflater)
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            textview.text = fruites[position].name
        }
    }

    override fun getItemCount(): Int {
        return fruites.size
    }

    fun getUpdateIterface(): Update {
        return update
    }

    val update = object : Update {
        override fun onProgressChanged(progress: Int) {
            Log.e("TAG", "onProgressChanged: ${progress}")
            this@MyRecyclerViewAdapter.progress = progress
        }
    }

    interface Update {
        fun onProgressChanged(progress: Int)
    }

}


class MyViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {

}




