package id.kotlin.student.features.student

import io.reactivex.Single

class StudentRepository(private val factory: StudentFactory) {

  fun getStudent(): Single<StudentEntity> =
      factory.getStudent().map { response ->
        val student = response.data?.map { data ->
          Student(
              id = data.id ?: 0L,
              name = data.name ?: "",
              email = data.email ?: ""
          )
        }

        StudentEntity(student = student ?: emptyList())
      }
}