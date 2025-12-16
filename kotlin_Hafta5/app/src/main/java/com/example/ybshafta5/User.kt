package com.example.ybshafta5

// özellik (property) ve fonksiyonların (functions) bir arada
// mantıklı, hiyerarşik olarak barındırılmasını sağlar

open class User {
    // var user_name: String = "Furkan" bu kullanımda kotlin diyor ki
    // sen zaten başlangıçta bana bir değişken verdin bunu sonradan
    // null yapamazsın.

    // Encapsulation işlemi, herhangi bir property'ye doğrudan erişimin
    // önüne geçmek ve kullanıcıyı kısıtlama getirmek için yapılır.
    // Tamamen güvenlik odaklı bir yaklaşımdır.

    // Önce kapsülleyeceğimiz property'yi mutlaka ama mutlaka private
    // tipinde yazıyoruz
    private var user_name: String  = ""

    fun setUser_Name(USERNAME: String){
        user_name = USERNAME
    }

    fun getUserName(): String = user_name //Bu yapı, Kotlin'de "Tek İfadeli Fonksiyon" olarak bilinir. Bu kısaltma, fonksiyonun geleneksel (uzun) yazımının daha okunaklı bir versiyonudur:

    // var user_name: String? = null
    // yukarıdaki kullanımda ise kotlin diyor ki eğer en başta null
    // değeri alabilecek şekilde bir değişken tanımlamak istiyorsan o zaman
    // tipin yanına ? simgesi koy ki bunu daha en başta belirt

    var user_surname: String = ""

    var user_age: Int = 0

    open fun showInfo(){
        println("Name = $user_name , Surname = $user_surname , Age = ${user_age.toString()}")
    }
}