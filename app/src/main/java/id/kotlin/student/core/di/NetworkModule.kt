package id.kotlin.student.core.di

import android.app.Application
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import id.kotlin.student.BuildConfig
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.ConnectionPool
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

object HttpClientConfig {

  const val MAX_IDLE_CONNECTIONS: Int = 15
  const val CONNECT_TIMEOUT: Long = 30
  const val READ_TIMEOUT: Long = 15
  const val WRITE_TIMEOUT: Long = 15
  const val KEEP_ALIVE_DURATION: Long = 30 * 1000
  const val CACHE_SIZE: Long = 30 * 1024 * 1024
}

@Module
class NetworkModule {

  @Provides
  @Singleton
  fun providesCache(application: Application): Cache =
      Cache(
          application.cacheDir,
          HttpClientConfig.CACHE_SIZE
      )

  @Provides
  @Singleton
  fun providesConnectionPool(): ConnectionPool =
      ConnectionPool(
          HttpClientConfig.MAX_IDLE_CONNECTIONS,
          HttpClientConfig.KEEP_ALIVE_DURATION,
          TimeUnit.SECONDS
      )

  @Provides
  @Singleton
  fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor =
      HttpLoggingInterceptor().apply {
        level = when (BuildConfig.DEBUG) {
          true -> Level.BODY
          false -> Level.NONE
        }
      }

  @Provides
  @Singleton
  fun providesHttpClient(
      cache: Cache,
      connectionPool: ConnectionPool,
      httpLoggingInterceptor: HttpLoggingInterceptor
  ): OkHttpClient =
      OkHttpClient.Builder().apply {
        connectTimeout(HttpClientConfig.CONNECT_TIMEOUT, TimeUnit.SECONDS)
        readTimeout(HttpClientConfig.READ_TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(HttpClientConfig.WRITE_TIMEOUT, TimeUnit.SECONDS)
        retryOnConnectionFailure(true)
        cache(cache)
        connectionPool(connectionPool)
        addInterceptor(httpLoggingInterceptor)
      }.build()

  @Provides
  @Singleton
  fun providesHttpAdapter(httpClient: OkHttpClient): Retrofit =
      Retrofit.Builder().apply {
        client(httpClient)
        baseUrl("${BuildConfig.URL}/api/")
        addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
      }.build()
}