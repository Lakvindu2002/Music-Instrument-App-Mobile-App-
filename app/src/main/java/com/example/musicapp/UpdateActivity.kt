package com.example.musicapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.musicapp.databinding.ActivityUpdateBinding
import com.example.musicapp.databinding.ActivityUploadinfoBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
//done
class UpdateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {

            val referenceInstrumentName=binding.referenceInstrumentName.text.toString()
            val updateFounder=binding.updateFounderName.text.toString()
            val updateYear=binding.updateDate.text.toString()
            val updateDescription=binding.updateDescription.text.toString()
            val updateCountry=binding.updateCountry.text.toString()

            updateData(referenceInstrumentName,updateFounder,updateYear,updateDescription,updateCountry)
        }

    }

    private fun  updateData(instrumentName :String,Founder:String,Year:String,Description:String,Country:String){

        databaseReference=FirebaseDatabase.getInstance().getReference("Information")
        val musicData= mapOf<String ,String>("foundername" to Founder,"year" to Year,"description" to Description,"country" to Country)
        databaseReference.child(instrumentName).updateChildren(musicData).addOnSuccessListener {

            binding.referenceInstrumentName.text.clear()
            binding.updateFounderName.text.toString()
            binding.updateDescription.text.toString()
            binding.updateCountry.text.toString()
            binding.updateDate.text.toString()
            Toast.makeText(this,"Updated", Toast.LENGTH_SHORT).show()


        }.addOnFailureListener{
            Toast.makeText(this,"Unable to Update",Toast.LENGTH_SHORT).show()
        }
    }
}