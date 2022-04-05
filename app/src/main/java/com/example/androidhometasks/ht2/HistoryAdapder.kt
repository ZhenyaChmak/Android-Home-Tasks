package com.example.androidhometasks.ht2

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhometasks.databinding.FragmentRecyclerviewHistoryCalculatorBinding

class HistoryAdapder(private val list: List<String>) : RecyclerView.Adapter<MyViewHolderHistory>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderHistory {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolderHistory, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}

class MyViewHolderHistory(private val binding: FragmentRecyclerviewHistoryCalculatorBinding) :
    RecyclerView.ViewHolder(binding.root){

}