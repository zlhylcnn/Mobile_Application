package com.example.ybshafta11database

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*
import androidx.lifecycle.lifecycleScope // AppDatabase2.kt dosyasındaki
// suspend isimli metot için ekleme işlemini uygulamayı dondurmadan
// gerçekleştirmeye yarayacak

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = findViewById<EditText>(R.id.etName)
        val surname = findViewById<EditText>(R.id.etSurname)
        val mail = findViewById<EditText>(R.id.etMail)
        val savebutton = findViewById<Button>(R.id.buttonSave)

        // veri tabanı bağlantısını açıyoruz

        val db = AppDatabase2.getDatabase(this)

        // butona tıklandığında ilgili verileri veri tabanına
        // kaydeden kodu yazıyoruz

        savebutton.setOnClickListener {
            val user_name = name.text.toString()
            val user_surname = surname.text.toString()
            val user_mail = mail.text.toString()

            if(!user_name.isEmpty() && !user_surname.isEmpty() &&
                !user_mail.isEmpty()){

                lifecycleScope.launch {
                    val newUser = User(name=user_name, surname=user_surname,
                        mail = user_mail)

                    db.userDao().insertUser(newUser)

                    runOnUiThread {
                        Toast.makeText(this@MainActivity,
                            "Kullanıcı başarıyla kaydedildi",
                            Toast.LENGTH_SHORT).show()
                        name.text.clear()
                        surname.text.clear()
                        mail.text.clear()
                    }
                }


            }
            else{
                Toast.makeText(this,
                    "Lütfen boş alan bırakmayınız",
                    Toast.LENGTH_SHORT).show()
            }
        }



    }
}