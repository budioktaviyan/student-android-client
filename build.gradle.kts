buildscript {
  repositories {
    google()
    jcenter()
  }

  dependencies {
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.40")
    classpath("org.jetbrains.kotlin:kotlin-serialization:1.3.40")
    classpath("com.android.tools.build:gradle:3.4.1")
  }
}

allprojects {
  repositories {
    google()
    jcenter()
  }
}
