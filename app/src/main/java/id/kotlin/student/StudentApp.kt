package id.kotlin.student

import android.app.Application
import id.kotlin.student.core.di.ApplicationComponent
import id.kotlin.student.core.di.DaggerApplicationComponent

class StudentApp : Application() {

  companion object {

    lateinit var component: ApplicationComponent
      private set
  }

  override fun onCreate() {
    super.onCreate()
    component = DaggerApplicationComponent.builder().application(this).build()
  }
}