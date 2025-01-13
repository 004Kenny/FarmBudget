package com.example.farmbudget

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RecoverPassword : AppCompatActivity() {

    private lateinit var otpBox1: EditText
    private lateinit var otpBox2: EditText
    private lateinit var otpBox3: EditText
    private lateinit var otpBox4: EditText
    private lateinit var otpBox5: EditText
    private lateinit var resetPasswordButton: Button
    private lateinit var resendCodeLink: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recover_password)

        otpBox1 = findViewById(R.id.otpBox1)
        otpBox2 = findViewById(R.id.otpBox2)
        otpBox3 = findViewById(R.id.otpBox3)
        otpBox4 = findViewById(R.id.otpBox4)
        otpBox5 = findViewById(R.id.otpBox5)
        resetPasswordButton = findViewById(R.id.btnResetPassword)
        resendCodeLink = findViewById(R.id.resendOtp)

        setupOtpInput()

    }

    //text listener setup to automatically move focus between boxes
    private fun setupOtpInput(){
        val otpBoxes = listOf(otpBox1, otpBox2, otpBox3, otpBox4, otpBox5)
        for (i in otpBoxes.indices){
            otpBoxes[i].addTextChangedListener(object: TextWatcher{
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    if (!s.isNullOrEmpty() && i < otpBoxes.size - 1) {
                        otpBoxes[i + 1].requestFocus() //move to the next box
                    } else if (s.isNullOrEmpty() && i > 0){
                        otpBoxes[i - 1].requestFocus() //move to the previous box if empty
                    }
                }
            })
        }
    }

    //get the otp inputted by the user
    private fun getOtpInput(): String {
        return otpBox1.text.toString() + otpBox2.text.toString() + otpBox3.text.toString() +
                otpBox4.text.toString() + otpBox5.text.toString()
    }
}