package id.kotlin.student.features.student

import id.kotlin.student.core.presentation.Model
import id.kotlin.student.core.presentation.View

interface StudentView : View {

  fun onShowLoading()
  fun onHideLoading()
  fun onFetchSuccess(model: StudentModel)
  fun onFetchFailed(model: Model)
}