package com.example.mvpapifetch.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvpapifetch.Model.Data
import com.example.mvpapifetch.databinding.CardBinding

class Adapter(private val context:Context,private val data:List<Data>):RecyclerView.Adapter<Adapter.ViewHolder>() {

   inner class ViewHolder(val cardBinding: CardBinding):RecyclerView.ViewHolder(cardBinding.root) {
        fun bind(data: Data){
            cardBinding.apply{
                textv.text = data.food
                Glide.with(context).load(data.image).circleCrop().into(imageview)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(data[position])
    }

    override fun getItemCount(): Int {
      return data.size
    }
}