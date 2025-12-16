package com.example.urlshortenerhafta12

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import android.content.Context
import android.content.ClipboardManager
import android.content.ClipData
import android.widget.*
import androidx.room.Room
import java.util.UUID
import android.content.Intent
import android.net.Uri

class MainActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "url-shortener-db"
        ).build()

        handleDeepLink()
        // --- UI Tanımlamaları ---
        val etLong = findViewById<EditText>(R.id.etLongUrl)
        val etShort = findViewById<EditText>(R.id.etShortUrl)
        val btnShorten = findViewById<Button>(R.id.btnShortener)
        val btnCopy = findViewById<Button>(R.id.btnCopy) // Artık normal Button
        //val db = AppDatabase.getDatabase(this)

        btnShorten.setOnClickListener {
            val longUrl = etLong.text.toString()

            if (longUrl.isNotEmpty()) {
                val code = UUID.randomUUID().toString().take(6)
                val shortLink = "https://kisa.link/$code"

                // Veritabanına Yaz
                lifecycleScope.launch {
                    db.linkDao().insertLink(Link(longUrl = longUrl, shortCode = code))

                    // Ekrana Yaz
                    etShort.setText(shortLink)
                    Toast.makeText(this@MainActivity, "Link oluşturuldu!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Lütfen bir URL girin", Toast.LENGTH_SHORT).show()
            }
        }

        btnCopy.setOnClickListener {
            val textToCopy = etShort.text.toString()

            if (textToCopy.isNotEmpty()) {
                val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("Short URL", textToCopy)
                clipboard.setPrimaryClip(clip)

                Toast.makeText(this, "Panoya kopyalandı", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Kopyalanacak link yok", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun handleDeepLink() {
        val action: String? = intent?.action
        val data: Uri? = intent?.data

        if (Intent.ACTION_VIEW == action && data != null) {
            val code = data.lastPathSegment

            if (code != null) {
                lifecycleScope.launch {
                    val linkObj = db.linkDao().getLinkByCode(code)
                    if (linkObj != null) {
                        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(linkObj.longUrl))
                        startActivity(browserIntent)
                        finish()
                    } else {
                        Toast.makeText(this@MainActivity, "Link bulunamadı!", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}