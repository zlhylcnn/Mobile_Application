 package com.example.ybshafta2

import java.lang.Math.pow

fun main(){
    println("Hello World!")

    val degistirilmez = 15
    var degistirilebilir = "Furkan"

    val sayi_int: Int=320000
    val sayi_long: Long=350000000L
    val sayi_double: Double=25.4698
    val sayi_float: Float=3565.156f

    val deger_char: Char='F'        
    val deger_string: String="Ahmet"

    println("Degisken Degeri = $sayi_int Degisken Tipi = ${sayi_int::class.simpleName}")// sadece sınıfın adını döndürür int yani

    //if kullanımı: kendi verdiğiniz bir değişken değerinin tek mi çift mi
    // olduğunu kontrol eden kodu yazınız.

    if(sayi_int%2==0)
    {
        println("$sayi_int sayisi cift sayidir")
    }
    else
    {
        println("$sayi_int sayisi tek sayidir")
    }

    // Dışarıdan (kullanıcıdan) değer alarak if yapısı hazırlama

    // NOT: readline() metodu ile kullanıcıdan değer alınır.

    val user_name_2: String = "Furkan"
    println("Deger Girisi: ")
    val user_name: String = readln()

    if(user_name!=user_name_2)
    {
        println("Kullanici adiniz hatali!!!!!")
    }
    else
    {
        println("Giris Basarili!")
    }
    println("Hoşgeldiniz, Sayın $user_name veri tipi = ${user_name::class.simpleName}")

    // Değer girişini kontrol ederek, kullanıcı adının doğru yazılıp
    // yazılmadığından emin olan kodu if ile yazınız


    // Kullanıcıdan iki adet tamsayı alınız ve bu iki sayıyla 4 temel
    // matematiksel işlemi gerçekleştiriniz...

    println("lütfen 1. sayıyı giriniz:")
    val sayi_1 = readln().toInt()

    print("Lütfen 2. sayıyı giriniz:")
    val sayi_2 = readln().toInt()

    val toplam = sayi_1 + sayi_2
    val fark = sayi_1 - sayi_2
    val carpim = sayi_1 * sayi_2
    val bolme = sayi_1 / sayi_2

    println("$sayi_1 + $sayi_2 = $toplam")
    println("$sayi_1 - $sayi_2 = $fark")
    println("$sayi_1 * $sayi_2 = $carpim")
    println("$sayi_1 / $sayi_2 = $bolme")

    //üs alma işlemi için pow() metodu kullanılır (double olarak yazılacak)
    var ornek_us = pow(2.0,4.0)
    println("Us derecesi sonucu = $ornek_us")

    // Kullanıcıdan kullanıcı adı ve şifre bilgisi alıp
    // her ikisinin de sizin verdiğiniz/istediğiniz değer olması
    // durumunda sisteme giriş başarılı mesajı veren if kodunu yazınız

    val kullanici_adi = "Furkan ATLAN"
    val kullanici_sifre = 123

    println("Lutfen Yeni Kullanici Adini Giriniz:")
    val new_k_adi = readln()

    println("Lutfen Yeni Sifrenizi Giriniz:")
    val new_k_sifre = readln().toInt()

    if(new_k_adi==kullanici_adi && new_k_sifre==kullanici_sifre)
    {
        println("Tebrikler. Sisteme Basarili Sekilde Giris Yaptiniz")
    }

    else if(new_k_adi!=kullanici_adi && new_k_sifre==kullanici_sifre)
    {
        println("Kullanici adi hatali!!!")
    }
    else if(new_k_adi==kullanici_adi && new_k_sifre!=kullanici_sifre)//&& ve || yada demek
    {
        println("Sifreniz hatali!!!")
    }
    else
    {
        println("Kullanici adi ve sifreniz hatalidir!!!")
    }
}




