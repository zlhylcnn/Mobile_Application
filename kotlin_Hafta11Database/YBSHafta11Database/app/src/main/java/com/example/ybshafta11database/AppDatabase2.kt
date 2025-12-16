package com.example.ybshafta11database
import android.content.Context
import androidx.room.*

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id:Int=0,
    val name: String,
    val surname:String,
    val mail:String
)

// Modern yaklaşımlarda direkt class'a erişmek yerine
// access layer mantığı kullanılır (interface üzerinden erişilir)

@Dao
interface UserDao{
    @Insert
    suspend fun insertUser(user: User)
}

// Veritabanını tanımlama kısmı:
@Database([User::class], version = 1)
abstract class AppDatabase2 : RoomDatabase()
{
    abstract fun userDao(): UserDao

    // veri tabanı işlemlerinden Insert'i kendi fonksiyonumuzdan
    // inherit yaptıktan sonra statik seviyede bir object tanımlaması
    // yapıyoruz

    // Java'daki static anahtar kelimesinin buradaki karşılığı
    // companion'dur

    companion object{
        @Volatile private var instance: AppDatabase2?=null
        fun getDatabase(context: Context): AppDatabase2 =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext, AppDatabase2::class.java,
                    "my_app_db"
                ).build().also { instance = it }
            }
    }
}

