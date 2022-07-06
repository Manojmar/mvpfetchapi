package com.example.mvpapifetch.Presenter.Class

import android.util.Log
import com.example.mvpapifetch.mode.User
import com.example.mvpapifetch.Network.Api
import com.example.mvpapifetch.Presenter.Interface.ILogin
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login(private var iLoginView: ILogin) {
    fun loginn(email: String, password: String){
        if (email.isEmpty()||password.isEmpty()){
            iLoginView.onLoginFailer("Required Field is empty")
        }
        else {
            val jsonObject = JsonObject()
            try {
                jsonObject.apply {
                    addProperty("email", email)
                    addProperty("password", password)
                }

                Api().login(jsonObject).enqueue(object : Callback<User> {
                    /*Responce Varathanu pake*/
                        override fun onResponse(call: Call<User>, response: Response<User>) {
                            if (response.isSuccessful) {
                                if (response.body()?.status_code == 200) {
                                    iLoginView.OnLoginSuccess(response.body()!!.message)
                                }
                            }
                        }
                        /*Not Connected*/
                        override fun onFailure(call: Call<User>, t: Throwable) {
                            iLoginView.onLoginFailer(t.message!!)
                        }
                    })
                /*Call Ah pokathuku*/
            } catch (exc: Exception) {
                Log.e("exc", exc.toString())
            }
        }
    }

}