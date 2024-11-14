package com.example.musicapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.musicapp.databinding.ActivitySigninBinding
import com.example.musicapp.databinding.ActivitySplashBinding
import android.os.Handler


class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Handler().postDelayed({
            // Start MainActivity
            val intent = Intent(this,SigninActivity ::class.java)
            startActivity(intent)
            finish()
        }, 4000)
        }

}