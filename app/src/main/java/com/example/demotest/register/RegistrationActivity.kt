package com.example.demotest.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.demotest.R
import com.example.demotest.databinding.ActivityLoginBinding
import com.example.demotest.databinding.ActivityRegisterationBinding
import com.example.demotest.login.LoginActivity

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar : Toolbar = binding.toolbar;
        setSupportActionBar(toolbar)
        supportActionBar!!.title = ""
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.Loginbtn.setOnClickListener {
            finish();
            val intent = Intent(this@RegistrationActivity,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}