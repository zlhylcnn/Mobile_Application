package com.example.ybshafta5

fun main(){
    var user_1 = User()

    user_1.setUser_Name("Furkan")
    user_1.user_surname = "ATLAN"
    user_1.user_age = 30

    user_1.showInfo()
    println("--------------------------------------")
    println("User Name = ${user_1.getUserName()}")

    // 4 temel işlemi sayi_1 ve sayi_2 property'leri üzerinden
    // gerçekleştiren bir class oluşturun

    // MyMath class'ından bir object (instance) türetiyoruz
    var mat_islem = MyMath()

    // mat_islem üzerinden 2 adet sayının değerini veriyoruz
    mat_islem.sayi_1 = 15
    mat_islem.sayi_2 = 2

    // 4 işlemi yapacağımız 2 sayıyı belirledikten sonra her bir işlem
    // için ilgili fonksiyonu yine mat_islem üzerinden çağırıyoruz
    mat_islem.toplama()
    mat_islem.cikarma()
    mat_islem.carpma()
    mat_islem.bolme()

    println("---------------------------------------------------")

    var student_1 = Students()
    student_1.setUser_Name("AHMET")

    student_1.user_surname = "TEKOK"
    student_1.user_age = 29


    student_1.vize = 58
    student_1.final_not = 72

    student_1.son_not()
    println("---------------------------------------------------")

    student_1.student_number = 25212 // atama işlemi aslında set işlemidir
    student_1.showInfo() // ekrana yazdırma işlemi de get işlemidir
    user_1.showInfo()
    println("---------------------------------------------------")

    // Abstract class'lardan instance türetilemez!!!!
    // var my_new_user = NewUser()

    // Abstract class'lar sadece miras alınmak için oluşturulurlar
    // Bu nedenle, abstract class'ın kendisinden değil de onu kendine
    // miras alan bir sınıftan instance oluşturabiliriz

    var my_new_student_1 = NewStudents()

    my_new_student_1.setAllProperties("Furkan","ATLAN",30)
    my_new_student_1.student_number = 10250

    // abstract metot
    my_new_student_1.newShowInfo()

    // polymorphism örneği
    my_new_student_1.belong_class()

}