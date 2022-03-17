package com.chikalfachdiana.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.chikalfachdiana.recyclerview.databinding.ListItemBinding
import com.chikalfachdiana.recyclerview.model.Hewan
import com.chikalfachdiana.recyclerview.model.getDataHewan


class MainAdapter(): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    private val data: List<Hewan> = getDataHewan()

    var onItemClick: ((Hewan) -> Unit)? = null

    inner class MainViewHolder(val binding : ListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.binding.nama.text = data[position].nama
        holder.binding.namaLatin.text = data[position].namaLatin
        holder.binding.jenisHewan.text = data[position].jenisHewan
        holder.binding.imageView.setImageResource(data[position].imgResId)
        holder.itemView.setOnClickListener {
            onItemClick!!.invoke(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }


}