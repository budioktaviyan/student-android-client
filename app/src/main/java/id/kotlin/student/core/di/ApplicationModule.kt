package id.kotlin.student.core.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import id.kotlin.student.core.executor.JobExecutor
import id.kotlin.student.core.executor.UIThread
import javax.inject.Singleton

@Module
class ApplicationModule {

  @Provides
  @Singleton
  fun providesJobExecutor(): JobExecutor = JobExecutor()

  @Provides
  @Singleton
  fun providesUIThread(): UIThread = UIThread()

  @Provides
  @Singleton
  fun providesApplicationContext(application: Application): Context = application
}