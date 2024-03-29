include(":app")

pluginManagement {
  resolutionStrategy {
    eachPlugin {
      if (requested.id.id == "kotlin-multiplatform") {
        useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.40")
      }
      if (requested.id.id == "kotlinx-serialization") {
        useModule("org.jetbrains.kotlin:kotlin-serialization:1.3.40")
      }
    }
  }
}
