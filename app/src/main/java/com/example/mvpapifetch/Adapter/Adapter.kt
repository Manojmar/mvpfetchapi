package com.example.mvpapifetch.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mvpapifetch.R
import com.example.mvpapifetch.mode.Data
import com.example.mvpapifetch.databinding.CardBinding

class Adapter(private val context:Context,private val data:List<Data>):RecyclerView.Adapter<Adapter.ViewHolder>() {

   inner class ViewHolder(val cardBinding: CardBinding):RecyclerView.ViewHolder(cardBinding.root) {
        fun bind(data: Data){
               cardBinding.dataa=data
               cardBinding.executePendingBindings()
//                Glide.with(context).load(data.image).circleCrop().into(cardBinding.imageview)
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

    companion object{
        @BindingAdapter("profileImageUrl")
        @JvmStatic
        fun loadImage(view: ImageView, url: String?) {
            Glide.with(view.context)
                .load(url)
                .circleCrop()
                .into(view)
        }
    }
}