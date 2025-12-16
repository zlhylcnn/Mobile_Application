package com.example.ybshafta5

class Students: User() {

    private var user_name: String = ""

    var student_number: Int = 0
    var lessons = mutableListOf<String>()

    var vize = 0
    var final_not = 0

    // vizenin %40'ıyla finalin %60'ını hesaplayıp ekrana yazdıran
    // fonksiyonu yazınız

    fun son_not(){
        var sonuc = (vize*0.4) + (final_not*0.6)
        println("Ogrencinin Ortalama Notu = $sonuc")
    }

    override fun showInfo() {
        println("Name = ${getUserName()} , Ogrenci No = $student_number")
    }


}