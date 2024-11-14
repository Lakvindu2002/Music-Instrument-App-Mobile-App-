package com.example.musicapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.musicapp.databinding.ActivityUploadinfoBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.lang.ref.PhantomReference

//done

class UploadinfoActivity : AppCompatActivity() {

    private lateinit var binding:com.example.musicapp.databinding.ActivityUploadinfoBinding
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding=ActivityUploadinfoBinding.inflate(layoutInflater)
        setContentView(binding.root)


     binding.saveButton.setOnClickListener {

         val instrumentname=binding.uploadInstrumentName.text.toString()
         val foundername =binding.uploadFounderName.text.toString()
         val year=binding.uploadDate.text.toString()
         val description=binding.uploadDescription.text.toString()
         val country=binding.uploadCountry.text.toString()

         databaseReference=FirebaseDatabase.getInstance().getReference("Information")
         val musicData=Music(instrumentname,foundername,year,description,country)
         databaseReference.child(instrumentname).setValue(musicData).addOnSuccessListener {

             binding.uploadInstrumentName.text.clear()
             binding.uploadDate.text.clear()
             binding.uploadCountry.text.clear()
             binding.uploadFounderName.text.clear()
             binding.uploadDescription.text.clear()

             Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show()
             val intent=Intent(this,UploadActivity::class.java)
             startActivity(intent)
             finish()
         }.addOnFailureListener {
             Toast.makeText(this,"Failed00",Toast.LENGTH_SHORT).show()
         }
     }
    }
}