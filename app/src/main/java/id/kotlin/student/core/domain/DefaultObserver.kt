package id.kotlin.student.core.domain

import io.reactivex.observers.DisposableSingleObserver

abstract class DefaultObserver<T> : DisposableSingleObserver<T>() {

  override fun onSuccess(entity: T) {}
  override fun onError(exception: Throwable) {}
}