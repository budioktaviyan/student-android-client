package id.kotlin.student.features.student

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import id.kotlin.student.R
import id.kotlin.student.core.presentation.Activity
import id.kotlin.student.core.presentation.Model
import id.kotlin.student.ext.hide
import id.kotlin.student.ext.show
import kotlinx.android.synthetic.main.activity_student.*
import id.kotlin.student.StudentApp.Companion.component as Injector

class StudentActivity : Activity<StudentView, StudentPresenter>(), StudentView {

  override fun onCreate(savedInstanceState: Bundle?) {
    Injector.student.build().inject(this)
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_student)
    rv_student.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    rv_student.setHasFixedSize(true)

    presenter.getStudent()
  }

  override fun onShowLoading() {
    pb_student.show()
  }

  override fun onHideLoading() {
    pb_student.hide()
  }

  override fun onFetchSuccess(model: StudentModel) {
    rv_student.adapter = StudentAdapter(model.student)
    tv_student_empty.hide()
  }

  override fun onFetchFailed(model: Model) {
    tv_student_empty.text = model.message
    tv_student_empty.show()
  }
}