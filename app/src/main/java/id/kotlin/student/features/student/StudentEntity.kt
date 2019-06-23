package id.kotlin.student.features.student

data class StudentEntity(val student: List<Student>)

data class Student(val id: Long,
                   val name: String,
                   val email: String
)