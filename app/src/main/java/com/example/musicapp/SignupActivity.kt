package com.example.musicapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.musicapp.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
//initialize firebase authintication
        firebaseAuth= FirebaseAuth.getInstance()
        binding.signupButton.setOnClickListener {
            val email=binding.signupEmial.text.toString()
            val password=binding.signupPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && password.length>4){
                firebaseAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this){
                            task->
                        if(task.isSuccessful){
                            Toast.makeText(this,"SignUp Successful", Toast.LENGTH_SHORT).show()
                            val intent= Intent(this,SigninActivity::class.java)
                            startActivity(intent)
                            finish()
                        }else{
                            Toast.makeText(this,"Try Again", Toast.LENGTH_SHORT).show()
                        }
                    }

            }else{
                Toast.makeText(this,"Fill all inputs ", Toast.LENGTH_SHORT).show()
            }
        }

        binding.LoginText.setOnClickListener{
            val intent= Intent(this,SigninActivity::class.java)
            startActivity(intent)

        }
    }
}