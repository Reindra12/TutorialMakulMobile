package com.example.tutorialpertama.Login

import android.content.Intent
import android.os.Bundle
import retrofit2.Callback
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tutorialpertama.LoginActivity
import com.example.tutorialpertama.R
import com.example.tutorialpertama.data.remote.ApiConfigRetrofit
import com.example.tutorialpertama.data.remote.ApiServiceRetrofit
import com.example.tutorialpertama.data.remote.model.RegisterRequest
import com.example.tutorialpertama.data.remote.model.RegisterResponse
import com.example.tutorialpertama.databinding.ActivityRegisterBinding
import retrofit2.Call
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private val binding: ActivityRegisterBinding by lazy {
        ActivityRegisterBinding.inflate(layoutInflater)
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




        binding.btnRegister.setOnClickListener {
            
            if (GoToRegister()){
                var name = binding.tvNama.text.toString().trim()
                var email = binding.tvEmail.text.toString().trim()
                var password = binding.tvPassword.text.toString().trim()


                fetchData(name, email, password, "https://picsum.photos/800")

            }
            }
        }

    private fun fetchData(name: String, email: String, password: String, avatar: String) {
            val request = RegisterRequest(name, email, password, avatar)
            ApiConfigRetrofit.instance.registerUser(request).enqueue(object : Callback<RegisterResponse> {
                override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                        intent.putExtra("email", email)
                        intent.putExtra("password", password)
                        startActivity(intent)
                        finish()
                        Toast.makeText(this@RegisterActivity, "Welcome ${responseBody?.name}!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@RegisterActivity, "Registration failed", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    Toast.makeText(this@RegisterActivity, t.message, Toast.LENGTH_SHORT).show()
                }
            })
        }


    private fun GoToRegister(): Boolean {
        var name = binding.tvNama.text.toString().trim()
        var email = binding.tvEmail.text.toString().trim()
        var password = binding.tvPassword.text.toString().trim()
        var date = binding.tvTanggal.text.toString().trim()
        var user = binding.tvUsername.text.toString().trim()

        if (name.isNullOrEmpty()) {
            binding.tinputNama.error = "Silahkan Lengkapi Nama Anda"
            return  false
        }else if (email.isNullOrEmpty()) {
            binding.tinputEmail.error = "Silahkan Lengkapi Email Anda"
            return  false
        }else if (date.isNullOrEmpty()) {
            binding.tinputTanggal.error = "Silahkan Lengkapi Tanggal Anda"
            return  false
        }else if (user.isNullOrEmpty()) {
            binding.tinputUsername.error = "Silahkan Lengkapi Username Anda"
            return  false
        }else if (password.isNullOrEmpty()) {
            binding.tinputPassword.error = "Silahkan Lengkapi Password Anda"
            return  false
        }
        return true
    }
}