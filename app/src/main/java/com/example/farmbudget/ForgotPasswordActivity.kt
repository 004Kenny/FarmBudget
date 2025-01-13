package com.example.farmbudget

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_forgot_password)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val backToLogin = findViewById<TextView>(R.id.tvLogin_ForgotPassword)
        backToLogin.setOnClickListener {
            val backToLoginIntent = Intent (this, LoginActivity::class.java)
            startActivity(backToLoginIntent)
            finish()
        }
        val getOtp = findViewById<Button>(R.id.getOtpBtn)
        getOtp.setOnClickListener {
            val getOtpIntent = Intent(this, RecoverPassword::class.java)
            startActivity(getOtpIntent)
            finish()
        }
    }
}