package id.kotlin.student.core.presentation

import id.kotlin.student.core.domain.Usecase

interface IPresenter<T : View> {

  fun onAttach(view: T)
  fun onDetach()
}

abstract class Presenter<T : View>(vararg usecases: Usecase<*, *>) : IPresenter<T> {

  private lateinit var view: T

  private val listOfUsecase: List<Usecase<*, *>> = ArrayList()

  init { usecases.map { listOfUsecase.plus(it) } }

  override fun onAttach(view: T) {
    this.view = view
  }

  override fun onDetach() {
    listOfUsecase.map { it.dispose() }
  }

  protected fun getView(): T = view
}