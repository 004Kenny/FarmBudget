package com.example.farmbudget

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WelcomeScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val createAccountBtn = findViewById<Button>(R.id.btnWelcome_createAccount)
        createAccountBtn.setOnClickListener {
            val createAccountPageIntent = Intent(this, CreateAccount::class.java)
            startActivity(createAccountPageIntent)
        }

        val loginAccountBtn = findViewById<Button>(R.id.btnWelcomeLogin)
        loginAccountBtn.setOnClickListener {
            val loginAccountIntent = Intent (this, LoginActivity::class.java)
            startActivity(loginAccountIntent)
        }
    }
}