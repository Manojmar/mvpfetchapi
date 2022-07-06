package com.example.mvpapifetch.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mvpapifetch.Presenter.Class.Login
import com.example.mvpapifetch.Presenter.Interface.ILogin
import com.example.mvpapifetch.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(),ILogin{
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var loginpresenter: Login
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        loginpresenter = Login(this)

       mainBinding.btn.setOnClickListener {
            val mail = mainBinding.edit1.text.toString()
            val pass = mainBinding.edit2.text.toString()
            loginpresenter.loginn(mail, pass)
        }
    }

    override fun onLoginFailer(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun OnLoginSuccess(message: String) {
        mainBinding.edit1.text.clear()
        mainBinding.edit2.text.clear()

        val intent = Intent(this@MainActivity, list::class.java)
        startActivity(intent)
        finish()
    }
}