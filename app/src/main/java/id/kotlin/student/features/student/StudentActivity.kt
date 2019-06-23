package id.kotlin.student.features.student

import android.os.Bundle
import id.kotlin.student.R
import id.kotlin.student.core.presentation.Activity
import id.kotlin.student.core.presentation.Model
import id.kotlin.student.StudentApp.Companion.component as Injector

class StudentActivity : Activity<StudentView, StudentPresenter>(), StudentView {

  override fun onCreate(savedInstanceState: Bundle?) {
    Injector.student.build().inject(this)
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_student)
  }

  override fun onShowLoading() {}

  override fun onHideLoading() {}

  override fun onFetchSuccess(model: StudentModel) {}

  override fun onFetchFailed(model: Model) {}
}