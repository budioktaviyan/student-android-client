package id.kotlin.student.features.student

import dagger.Subcomponent
import id.kotlin.student.core.di.PerFeature

@PerFeature
@Subcomponent(modules = [StudentModule::class])
interface StudentComponent {

  @Subcomponent.Builder
  interface Builder {

    fun build(): StudentComponent
  }

  fun inject(activity: StudentActivity)
}