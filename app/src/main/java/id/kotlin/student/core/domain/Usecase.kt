package id.kotlin.student.core.domain

import id.kotlin.student.core.executor.PostExecutionThread
import id.kotlin.student.core.executor.ThreadExecutor
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

abstract class Usecase<T, in Params>(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread) {

  private val disposables: CompositeDisposable = CompositeDisposable()

  protected abstract fun buildUsecaseObservable(params: Params): Single<T>

  fun execute(singleObserver: DefaultObserver<T>, params: Params) {
    val single: Single<T> = buildUsecaseObservable(params)
        .subscribeOn(Schedulers.from(threadExecutor))
        .observeOn(postExecutionThread.scheduler)
    disposables.add(single.subscribeWith(singleObserver))
  }

  fun dispose() {
    disposables.clear()
  }
}