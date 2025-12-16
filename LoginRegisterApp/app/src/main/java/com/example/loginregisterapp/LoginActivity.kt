package com.example.loginregisterapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.content.Intent

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val username_editText = findViewById<EditText>(R.id.editTextUsername)
        val password_editText = findViewById<EditText>(R.id.editTextPassword)
        val loginbutton = findViewById<Button>(R.id.buttonLogin)
        val registerlinkView = findViewById<TextView>(R.id.textViewRegisterLink)

        loginbutton.setOnClickListener{
            val username = username_editText.text.toString()
            val password = password_editText.text.toString()

            if(username == "admin" && password=="1234")
            {
                Toast.makeText(this,
                    getString(R.string.login_success),
                    Toast.LENGTH_LONG).show()

                val intent = Intent(this,
                    DashboardActivity::class.java)

                startActivity(intent)

                // sonrasında geri tuşuna basıp, loginActivity'ye gelmesi için
                // aşağıdaki kodu yazıyoruz

                finish()

            }

            else
            {
                Toast.makeText(this,
                    getString(R.string.login_error),
                    Toast.LENGTH_LONG).show()
            }


        }

    }
}