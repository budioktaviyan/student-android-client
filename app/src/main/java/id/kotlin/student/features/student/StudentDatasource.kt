package id.kotlin.student.features.student

import io.reactivex.Single
import retrofit2.http.GET

interface StudentDatasource {

  @GET("v1/student")
  fun getStudent(): Single<StudentResponse>
}