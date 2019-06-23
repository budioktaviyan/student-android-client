package id.kotlin.student.features.student

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StudentModel(
    val student: List<Student>
) : Parcelable {

  @Parcelize
  data class Student(
      val name: String,
      val email: String
  ) : Parcelable
}