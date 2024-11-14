package com.example.musicapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.musicapp.databinding.ActivitySigninBinding
import com.google.firebase.auth.FirebaseAuth

class SigninActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySigninBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth =FirebaseAuth.getInstance()
        binding.loginButton.setOnClickListener {
            val email =binding.loginEmail.text.toString()
            val password =binding.loginPassword.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty()){

                firebaseAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this){task->
                        if (email == "admin@gmail.com"){
                            val intent = Intent(this, UploadActivity::class.java)
                            startActivity(intent)

                        }else if(task.isSuccessful){
                            Toast.makeText(this, "login Successful", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, SearchActivity::class.java)
                            startActivity(intent)

                        }
                        else{
                            Toast.makeText(this,"login failed", Toast.LENGTH_SHORT).show()
                        }
                    }
            }else{
                Toast.makeText(this,"Plaese enter E-mail and password", Toast.LENGTH_SHORT).show()
            }
            binding.signupTextt.setOnClickListener {
                val intent= Intent(this,SignupActivity::class.java)
                startActivity(intent)

            }
        }

    }
}