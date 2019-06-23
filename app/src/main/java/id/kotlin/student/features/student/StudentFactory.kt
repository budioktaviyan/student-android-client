package id.kotlin.student.features.student

import io.reactivex.Single

class StudentFactory(private val datasource: StudentDatasource) {

  fun getStudent(): Single<StudentResponse> =
      datasource.getStudent()
}