package com.example.tutorialpertama

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tutorialpertama.Login.RegisterActivity
import com.example.tutorialpertama.databinding.ActivityLoginBinding
import com.example.tutorialpertama.databinding.ActivityRegisterBinding

class LoginActivity : AppCompatActivity() {
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val username = intent.getStringExtra("email")
        binding.tvEmail.setText(username)
        val password = intent.getStringExtra("password")
        binding.tvPassword.setText(password)

        binding.tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            intent.putExtra("username", "Sapuji")
            startActivity(intent)
//            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}