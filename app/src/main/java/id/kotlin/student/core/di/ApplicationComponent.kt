package id.kotlin.student.core.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import id.kotlin.student.features.student.StudentComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [
  ApplicationModule::class,
  NetworkModule::class
])
interface ApplicationComponent {

  @Component.Builder
  interface Builder {

    @BindsInstance
    fun application(application: Application): Builder

    fun build(): ApplicationComponent
  }

  val student: StudentComponent.Builder
}