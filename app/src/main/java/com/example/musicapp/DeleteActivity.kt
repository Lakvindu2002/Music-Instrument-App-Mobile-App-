package com.example.musicapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.musicapp.databinding.ActivityDeleteBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


//done
class DeleteActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDeleteBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.deleteButton.setOnClickListener {

            val instrumentname=binding.deleteInstrumentName.text.toString()
            if (instrumentname.isNotEmpty()){
                deleteData(instrumentname)
            }else{
                Toast.makeText(this,"Please Enter Name" , Toast.LENGTH_SHORT).show()
            }
        }

    }
    private fun deleteData( instrumentname:String,){

        databaseReference = FirebaseDatabase.getInstance().getReference("Information")
        databaseReference.child(instrumentname).removeValue().addOnSuccessListener {

            binding.deleteInstrumentName.text.clear()
            Toast.makeText(this,"Data removed",Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this,"Unabale to delete",Toast.LENGTH_SHORT).show()
        }
    }

}