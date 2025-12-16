package com.example.ybshafta5

class MyMath {

    //property'leri tanıttık
    var sayi_1 = 0
    var sayi_2 = 0

    //Şimdi de bunları kullanarak 4 temel işlemi yapacak olan fonksiyonları
    // tanımlıyoruz

    fun toplama(){
        var sonuc = sayi_1 + sayi_2
        println("Toplam = ${sonuc.toString()}")
    }

    fun cikarma(){
        var sonuc = sayi_1 - sayi_2
        println("Cikarma = ${sonuc.toString()}")
    }

    fun carpma(){
        var sonuc = sayi_1 * sayi_2
        println("Carpim = ${sonuc.toString()}")
    }

    fun bolme(){
        var sonuc = sayi_1.toDouble() / sayi_2.toDouble()
        println("Bolme = ${sonuc.toString()}")
    }

}