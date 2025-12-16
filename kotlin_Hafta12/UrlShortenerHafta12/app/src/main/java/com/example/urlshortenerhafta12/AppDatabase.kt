package com.example.urlshortenerhafta12

import android.content.Context
import androidx.room.*

@Entity(tableName = "links")
data class Link(
    @PrimaryKey(autoGenerate = true) val id:Int=0,
    val longUrl: String,
    val shortCode:String
)

// Modern yaklaşımlarda direkt class'a erişmek yerine
// access layer mantığı kullanılır (interface üzerinden erişilir)

@Dao
interface LinkDao{
    @Insert
    suspend fun insertLink(link: Link)

    // select sorgusu yazıp son shortcode link'i aktarıyoruz
    @Query("Select * From links Where shortCode=:code LIMIT 1")
    suspend fun getLinkByCode(code: String):Link?
}

// Veritabanını tanımlama kısmı:
@Database([Link::class], version = 1)
abstract class AppDatabase : RoomDatabase()
{
    abstract fun linkDao(): LinkDao

    // veri tabanı işlemlerinden Insert'i kendi fonksiyonumuzdan
    // inherit yaptıktan sonra statik seviyede bir object tanımlaması
    // yapıyoruz

    // Java'daki static anahtar kelimesinin buradaki karşılığı
    // companion'dur

//    companion object{
//        @Volatile private var instance: AppDatabase?=null
//        fun getDatabase(context: Context): AppDatabase =
//            instance ?: synchronized(this) {
//                instance ?: Room.databaseBuilder(
//                    context.applicationContext, AppDatabase::class.java,
//                    "short_db"
//                ).build().also { instance = it }
//            }
//    }
}
