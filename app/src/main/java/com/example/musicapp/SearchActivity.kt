package com.example.musicapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.musicapp.databinding.ActivitySearchBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

// Main activity class for searching information
class SearchActivity : AppCompatActivity() {
    // Declare variables for binding and database reference
    private lateinit var binding: ActivitySearchBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize binding for this activity
        binding = ActivitySearchBinding.inflate(layoutInflater)
        // Set the content view to the root of the binding
        setContentView(binding.root)

        // Set click listener for the search button
        binding.searchButton.setOnClickListener {
            // Get the search name from the EditText
            val searchName = binding.searchInstrumentName.text.toString()

            // Check if the search name is not empty
            if (searchName.isNotEmpty()) {
                // Call the readData function with the search name
                readData(searchName)
            } else {
                // Show a toast message if the search name is empty
                Toast.makeText(this, "Please Enter Name", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Function to read data from Firebase
    private fun readData(searchName: String) {
        // Initialize the database reference to the "Information" node
        databaseReference = FirebaseDatabase.getInstance().getReference("Information")

        // Get the child with the search name from the database
        databaseReference.child(searchName).get().addOnSuccessListener {
            // Check if the data exists
            if (it.exists()) {
                // Retrieve the data from the database
                val founderName = it.child("foundername").value
                val year = it.child("year").value
                val description = it.child("description").value
                val country = it.child("country").value

                // Show a toast message indicating the result was found
                Toast.makeText(this, "Result Found", Toast.LENGTH_SHORT).show()

                // Clear the search input
                binding.searchInstrumentName.text.clear()

                // Set the retrieved data to the respective TextViews
                binding.readFounderName.text = founderName.toString()
                binding.readYear.text = year.toString()
                binding.readDescription.text = description.toString()
                binding.readCountry.text = country.toString()
            } else {
                // Show a toast message if the instrument name does not exist
                Toast.makeText(this, "Instrument name does not exist", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            // Show a toast message if there was an error retrieving the data
            Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show()
        }
    }
}
