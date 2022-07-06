package com.example.mvpapifetch.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvpapifetch.Adapter.Adapter
import com.example.mvpapifetch.Model.Data
import com.example.mvpapifetch.Presenter.Class.List
import com.example.mvpapifetch.Presenter.Interface.IList
import com.example.mvpapifetch.databinding.ActivityListBinding
import com.example.mvpapifetch.utils

class list : AppCompatActivity(),IList {
    private lateinit var listBinding: ActivityListBinding
    private lateinit  var listpresenter: List
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listBinding= ActivityListBinding.inflate(layoutInflater)
        setContentView(listBinding.root)

        listpresenter = List(this)
        listpresenter.getCountry()

    }

    override fun image(body: kotlin.collections.List<Data>) {
      adapter= Adapter(baseContext,body)
        listBinding.recycle.adapter=adapter
        listBinding.recycle.layoutManager=LinearLayoutManager(this)
    }
}