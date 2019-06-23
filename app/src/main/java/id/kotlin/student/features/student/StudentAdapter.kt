package id.kotlin.student.features.student

import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.view.ViewGroup
import id.kotlin.student.R
import id.kotlin.student.ext.inflate
import id.kotlin.student.features.student.StudentAdapter.StudentViewHolder
import kotlinx.android.synthetic.main.item_student.view.*

class StudentAdapter(private val student: List<StudentModel.Student>) : Adapter<StudentViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder =
      StudentViewHolder(parent.inflate(R.layout.item_student, parent))

  override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
    holder.bindView(student[holder.adapterPosition])
  }

  override fun getItemCount(): Int = student.size

  inner class StudentViewHolder(itemView: View) : ViewHolder(itemView) {

    fun bindView(model: StudentModel.Student) {
      with(itemView) {
        tv_student_name.text = model.name
        tv_student_email.text = model.email
      }
    }
  }
}