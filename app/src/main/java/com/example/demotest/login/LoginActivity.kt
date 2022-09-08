package com.example.demotest.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.demotest.R
import com.example.demotest.databinding.ActivityLoginBinding
import com.example.demotest.register.RegistrationActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar : Toolbar = binding.toolbar;
        setSupportActionBar(toolbar)
        supportActionBar!!.title = ""

        binding.Register.setOnClickListener {
            startActivity(Intent(this@LoginActivity,RegistrationActivity::class.java))
        }
    }
}