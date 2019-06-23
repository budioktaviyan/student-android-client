package id.kotlin.student.features.student

import dagger.Module
import dagger.Provides
import id.kotlin.student.core.di.PerFeature
import id.kotlin.student.core.executor.JobExecutor
import id.kotlin.student.core.executor.UIThread
import id.kotlin.student.ext.clazz
import retrofit2.Retrofit

@Module
class StudentModule {

  @PerFeature
  @Provides
  fun providesStudentDatasource(retrofit: Retrofit): StudentDatasource =
      retrofit.create(clazz<StudentDatasource>())

  @PerFeature
  @Provides
  fun providesStudentFactory(datasource: StudentDatasource): StudentFactory =
      StudentFactory(datasource)

  @PerFeature
  @Provides
  fun providesStudentRepository(factory: StudentFactory): StudentRepository =
      StudentRepository(factory)

  @PerFeature
  @Provides
  fun providesStudentUsecase(
      repository: StudentRepository,
      executor: JobExecutor,
      thread: UIThread
  ): StudentUsecase = StudentUsecase(repository, executor, thread)

  @PerFeature
  @Provides
  fun providesStudentPresenter(usecase: StudentUsecase): StudentPresenter =
      StudentPresenter(usecase)
}