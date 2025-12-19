package com.example.ybshafta4

fun main(){
    // array: sabit boyutlu veriler için kullanılır
    // ilk tanımlandığı boyutundan başka bir boyutla
    // kullanılamaz.

    // Bilinen en klasik veri yapısıdır.

    var my_arr_1 = arrayOf("Furkan","Ybs",30,"Mobil Programlama",true
    , 56.63)

    // tip güvenli array tanımlamak
    var my_arr_2: Array<Int> = arrayOf(15,86,73)

    //my_arr_1[6] = 72
    // array'ler ilk tanımlandığı andaki boyutlarını değiştiremedikleri
    // için sonradan bir boyut arttırımı (yeni bir değer ekleme)
    // işlemi yapılamaz. Ancak, var olan diğer indekslerdeki değerler
    // değiştirilebilir.

    println("0. indeksteki veri = ${my_arr_1[0]}")
    println("eleman sayısı = ${my_arr_1.size}")
    println("2. indeksteki eleman = ${my_arr_1.get(2)}")
    println(my_arr_1.set(2,"45"))
    println("2. indeksteki eleman = ${my_arr_1.get(2)}")

    println("--------------------------------------------------------")
    // value-reference type

    var a = 10
    var b = a

    b = b+5

    println("a = $a ---  b = $b")


    println("--------------------------------------------------------")

    // var list_deneme = listOf("Deneme1",56,false,75.12)//listof da degistirme düzeltme vs olmayacak yani
    // yukarıdaki gibi bir tanımlama yaparsanız, bu liste immutable bir
    // liste olacaktır. Tıpkı value type gibi davranır.


    var my_list1 = mutableListOf(10,15)//degistirilebilir liste demek ekleme cıkarma düzenleme yapabilirim yani
    //add(), remove(), set(), clear() gibi metotlar kullanılabilir
    var my_list2 = my_list1

    my_list2.add(20)

    println("my_list1 = $my_list1 -----  my_list2 = $my_list2")
    println("--------------------------------------------------------")

    var my_list3 = mutableListOf("MAKU","YBS",true,15,75.54,"son sınıf")

    // my_list3'teki tüm elemanları sırayla gösteriniz
    // yöntem-1: direkt listenin içine girip elemanları sıralama
    for (i in my_list3)
    {
        println(i)
    }

    println("--------------------------------------------------------")

    // yöntem-2: sayaç mantığıyla sıralama
    for(i in 0..my_list3.size-1)//listenin son elemanında hata vermesin, tam sonuna kadar dönsün.4 eleman var 4. indextekini çağırıca hata vericek,çünkü 3 eleman var.
    // Özetle, i in 0..my_list3.size-1 ifadesindeki -1, döngünün Listenin Boyutundan (Size) değil, Listenin Son İndeksine kadar çalışmasını sağlamak için oradadır.
    {
        println("${i+1}. Eleman = ${my_list3[i]}")
    }
     //-1 listenin son index,ne kadar calısması icin
    println("--------------------------------------------------------")
    // yöntem-3: foreach ile tek satırda yazdırmak

    my_list3.forEach { println(it) }//it o anki elemanı ifade eder yaani o döngüde o anki elemanı yazmasını ister printle

    println("--------------------------------------------------------")
    var my_list4 = mutableListOf<Int>(2,8,4,5,11,17,29,36,37,0,6,23)//güvenli değer tanımlaması yaptık yani

    // her bir değerin karesini yazdıran kodu yazınız
    // yöntem-1: for döngüsü ile
    for(i in 0..my_list4.size-1)
    {
        var deger = my_list4[i]
        println("Deger = ${deger} --- karesi = ${deger*deger}")
    }

    println("--------------------------------------------------------")

    //yöntem-2: map fonksiyonu ile
    println(my_list4.map { it * it })

    println("--------------------------------------------------------")

    // my_list4'te yer alan tek sayıları getiren kodu yazınız
    // yöntem-1: döngüyle halletmek

    for (i in 0..my_list4.size-1)
    {
        var deger = my_list4[i]
        if(deger%2!=0)
        {
            println("Tek Sayı = $deger")
        }
    }
    println("--------------------------------------------------------")
    // yöntem-2: filter fonksiyonu ile
    println(my_list4.filter { it%2 !=0 })//filter:Bir koleksiyondaki elemanları belirli bir koşula göre seçer.

    // my_list4'teki tek sayıların sayısını bulan kodu yazınız
    // yöntem-1: döngüyle
    println("--------------------------------------------------------")
    var my_list5 = mutableListOf(0)
    my_list5.remove(0)


    var sayac = 0
    for (i in 0..my_list4.size-1)
    {
        var deger = my_list4[i]
        if(deger%2!=0)
        {
            sayac++
            my_list5.add(deger)
            // sayac += 1  -- ya da sayac = sayac + 1

        }
    }
    println("$sayac adet tek sayi bulundu!")
    println("Yeni Liste = $my_list5")
    //tek sayıları yeni listeye ekleyip yeni listeyi yazdırıyor bro

    //yöntem-2: count fonksiyonu ile
    // count fonksiyonu, filter fonksiyonundan dönen eleman sayısını verir
    println("--------------------------------------------------------")
    println(my_list4.count{it%2 !=0})
    // yöntem-3: batuhan
    println(my_list4.filter { it%2!=0 }.size)

    // listede 100'den büyük sayı olup olmadığını kontrol edin
    // yöntem-1: döngüyle
    println("--------------------------------------------------------")
    sayac = 0
    for (i in 0..my_list4.size-1)
    {
        var deger = my_list4[i]
        if(deger>100)
        {
            sayac++
        }
    }
    if (sayac>0)
    {
        println("Listede 100'den büyük bir sayı var!")
    }
    else
    {
        println("Listedeki tum sayilar 100'den kucuktur")
    }
    // yöntem-2: all fonksiyonu ile
    // all fonksiyonu, istenen şart tüm elemanlar tarafından sağlandığında
    // true döner, tek bir istisna dahi olsa false döner
    println("--------------------------------------------------------")
    println("Listede tüm elemanlar 100'den küçük mü? cevap = ${my_list4.all { it<100 }}")
    println("--------------------------------------------------------")

    // set veri yapısı: Python'daki gibi küme mantığıyla çalışır.
    // içerisine aldığı değerleri benzersiz hale getirir.
    // Tekrar etmesini istemediğiniz veriler için kullanılır
    // Kümelerin sahip olduğu matematiksel işlemleri yapmaya olanak tanır

    var kume_1 = mutableSetOf(5,6,11,5,52,11,"YBS",106,82.10,73.45,"YBS")
    var kume_2 = mutableSetOf(15,53,false,"Furkan","YBS",15,11,82.10)

    println("--------------------------------------------------------")
    println("kume_1'in eleman sayısı = ${kume_1.size}")
    println("kume_2'nin eleman sayısı = ${kume_2.size}")
    println("--------------------------------------------------------")
    println("birlesim = ${kume_1.union(kume_2)}")
    println("kesisim = ${kume_1.intersect(kume_2)}")
    println("kume1 fark kume2 = ${kume_1.subtract(kume_2)}")
    println("kume2 fark kume1 = ${kume_2.subtract(kume_1)}")
    println("--------------------------------------------------------")

    // key-value birlikteliğine izin veren veri yapısı: MAP
    // "anahtar" to "değer"
    var my_map = mutableMapOf("isim" to "Furkan","soyisim" to "ATLAN",
        "bolum" to "YBS", "ders_sayisi" to 3)

    // sadece anahtarın adını yazsak, onun sakladığı değeri getirir
    println(my_map["isim"])

    // tüm anahtarları getirmek için
    println(my_map.keys)

    // tüm değerleri getirmek için
    println(my_map.values)

    // anahtar ve değerleri birlikte getirmek için
    println(my_map.entries)

    // sonradan bir anahtar ve değer eklemek için yöntem-1:
    my_map["faculty"] = "ZTYO"
    println(my_map.entries)

    // sonradan bir anahtar ve değer eklemek için yöntem-2:put fonksiyonu
    my_map.put("age",30)
    println(my_map.entries)

    // map veri yapısında silme işlemi key tabanlı yapılır
    my_map.remove("age")
    println(my_map.entries)

    // işçilerin ücretlerine %35 zam yapıp, ücretlerin yeni halini
    // yazdırınız

    var my_map_2 = mutableMapOf("isci_1" to 50000, "isci_2" to 29000,
        "isci_3" to 35000, "isci_4" to 70500)

    //yöntem-1: for döngüsüyle key,value 2 değişkenle map'in içine girmek
    println("--------------------------------------------------------")
    println("Maaslar ilk hali = ${my_map_2}")
    for((my_key,my_value) in my_map_2)
    {
        var yeni_maas = my_value * 1.35
        // ikinci formül = (my_value) + my_value*0.35
        my_map_2[my_key] = yeni_maas.toInt() //anahtarların degerlerinin hepsine ynei maaslı hallerini ekledik.
    }
    println("--------------------------------------------------------")
    println("Zamli maaslar = ${my_map_2}")

    // yöntem-2: map ile
    println(my_map_2.map{ it.value * 1.35 })



}