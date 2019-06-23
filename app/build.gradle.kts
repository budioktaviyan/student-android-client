plugins {
  id("com.android.application")
  id("kotlinx-serialization")
  kotlin("android")
  kotlin("android.extensions")
  kotlin("kapt")
}

@Suppress("OldTargetApi")
android {
  compileSdkVersion(28)
  buildToolsVersion = "29.0.0"

  defaultConfig {
    applicationId = "id.kotlin.student"
    minSdkVersion(24)
    targetSdkVersion(28)
    versionCode = 1
    versionName = "1.0.0"
  }

  bundle {
    density { enableSplit = true }
    abi { enableSplit = true }
    language { enableSplit = true }
  }

  compileOptions {
    setSourceCompatibility(1.8)
    setTargetCompatibility(1.8)
  }

  buildTypes {
    getByName("debug") {
      isDebuggable = true
      isMinifyEnabled = false
      buildConfigField("String", "URL", "\"http://8d1ed059.ngrok.io\"")
    }
  }
}

androidExtensions {
  isExperimental = true
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.40")
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.11.1")

  implementation("com.android.support:appcompat-v7:28.0.0")
  implementation("com.android.support:recyclerview-v7:28.0.0")
  implementation("com.android.support:design:28.0.0")
  implementation("com.android.support.constraint:constraint-layout:1.1.3")

  implementation("com.google.dagger:dagger:2.23.2")
  kapt("com.google.dagger:dagger-compiler:2.23.2")

  implementation("io.reactivex.rxjava2:rxjava:2.2.10")
  implementation("io.reactivex.rxjava2:rxkotlin:2.3.0")
  implementation("io.reactivex.rxjava2:rxandroid:2.1.1")

  implementation("com.squareup.retrofit2:retrofit:2.6.0")
  implementation("com.squareup.retrofit2:adapter-rxjava2:2.6.0")

  implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.4.0")

  implementation("com.squareup.okhttp3:okhttp:3.14.2")
  implementation("com.squareup.okhttp3:logging-interceptor:3.14.2")
}
