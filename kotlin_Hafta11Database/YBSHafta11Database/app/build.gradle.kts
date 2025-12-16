plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.ybshafta11database"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.ybshafta11database"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Room'un versiyonunu bir değişkene atayalım ki aşağıda tekrar tekrar yazmayalım.
    val roomVersion = "2.6.1"

    // 1. Room Runtime: Room'un çalışması için gereken temel kütüphane (Veritabanı oluşturma, sorgu atma vs.)
    implementation("androidx.room:room-runtime:$roomVersion")

    // 2. Room KTX: Kotlin eklentileri. Coroutines (suspend fonksiyonlar) kullanabilmemizi bu sağlar.
    implementation("androidx.room:room-ktx:$roomVersion")

    // 3. Room Compiler (KSP): İŞTE EN ÖNEMLİSİ BU.
    // Bu kütüphane uygulama çalışırken değil, DERLENİRKEN çalışır.
    // Senin yazdığın User ve UserDao sınıflarına bakar ve gerçek SQL kodlarını üretir.
    // 'ksp' komutu ile bunun bir derleme aracı olduğunu belirtiyoruz.
    ksp("androidx.room:room-compiler:$roomVersion")

    // Coroutines (Asenkron işlemler için)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
}