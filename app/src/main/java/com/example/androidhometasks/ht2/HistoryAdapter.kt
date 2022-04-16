package com.example.androidhometasks.ht2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhometasks.databinding.FragmentItemHistoryBinding

class HistoryAdapter(private val list: List<String>) : RecyclerView.Adapter<MyViewHolderHistory>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderHistory {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MyViewHolderHistory(
            binding = FragmentItemHistoryBinding.inflate(layoutInflater, parent, false),
        )
    }

    override fun onBindViewHolder(holder: MyViewHolderHistory, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class MyViewHolderHistory(private val binding: FragmentItemHistoryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(string: String) {
        binding.textViewItemHistory.text = string
    }

}