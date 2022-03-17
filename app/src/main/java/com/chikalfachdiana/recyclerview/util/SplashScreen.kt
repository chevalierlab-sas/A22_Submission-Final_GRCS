package com.chikalfachdiana.recyclerview.util


import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.chikalfachdiana.recyclerview.databinding.ActivitySplashScreenBinding
import com.chikalfachdiana.recyclerview.ui.MainActivity

@SuppressLint("SplashScreen")
class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.hide()

       Handler(Looper.getMainLooper()).postDelayed({
           startActivity(
              Intent(this@SplashScreen, MainActivity::class.java)
           )
       },3000)
        supportActionBar?.hide()
    }
}