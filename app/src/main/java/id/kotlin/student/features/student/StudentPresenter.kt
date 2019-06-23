package id.kotlin.student.features.student

import id.kotlin.student.core.domain.DefaultObserver
import id.kotlin.student.core.domain.Entity
import id.kotlin.student.core.presentation.Model
import id.kotlin.student.core.presentation.Presenter
import id.kotlin.student.ext.response

class StudentPresenter(
    private val usecase: StudentUsecase
) : Presenter<StudentView>() {

  fun getStudent() {
    getView().onShowLoading()
    usecase.execute(
        StudentUsecaseObserver(),
        null
    )
  }

  inner class StudentUsecaseObserver : DefaultObserver<StudentEntity>() {

    override fun onSuccess(entity: StudentEntity) {
      val student = entity.student.map { model ->
        StudentModel.Student(
            name = model.name,
            email = model.email
        )
      }
      val model = StudentModel(student = student)

      getView().onHideLoading()
      getView().onFetchSuccess(model = model)
    }

    override fun onError(exception: Throwable) {
      val entity = Entity(message = exception.response().message)
      val model = Model(message = entity.message)

      getView().onHideLoading()
      getView().onFetchFailed(model = model)
    }
  }
}