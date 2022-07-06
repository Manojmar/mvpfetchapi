package com.example.mvpapifetch.Presenter.Class

import android.util.Log
import com.example.mvpapifetch.mode.User
import com.example.mvpapifetch.Network.Api
import com.example.mvpapifetch.Presenter.Interface.IList
import com.example.mvpapifetch.utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class List(private val ilist:IList ) {

    fun getCountry() {
        Api().imgcount().enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful){
                utils.data = response.body()!!.data
                    ilist.image(utils.data)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("failure", t.toString())
            }
        })
    }
}