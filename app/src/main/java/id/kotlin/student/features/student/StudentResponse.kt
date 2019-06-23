package id.kotlin.student.features.student

import kotlinx.serialization.Serializable

@Serializable
data class StudentResponse(val data: List<Data>?) {

  @Serializable
  data class Data(val id: Long?,
                  val name: String?,
                  val email: String?
  )
}