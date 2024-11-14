package com.example.musicapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.musicapp.databinding.ActivityDeleteBinding
import com.example.musicapp.databinding.ActivityUploadBinding
///Routing done
class UploadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUploadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityUploadBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    binding.mainUpload.setOnClickListener {

        val intent=Intent(this,UploadinfoActivity::class.java)
        startActivity(intent)

    }
   binding.mainDelete.setOnClickListener {

       val intent=Intent(this,DeleteActivity::class.java)
       startActivity(intent)

   }

   binding.mainUpdate.setOnClickListener {
       val intent=Intent(this,UpdateActivity::class.java)
       startActivity(intent)

   }

    }
}