package id.kotlin.student.features.student

import id.kotlin.student.core.domain.Usecase
import id.kotlin.student.core.executor.JobExecutor
import id.kotlin.student.core.executor.UIThread
import io.reactivex.Single

class StudentUsecase(
    private val repository: StudentRepository,
    executor: JobExecutor,
    thread: UIThread
) : Usecase<StudentEntity, Any?>(executor, thread) {

  override fun buildUsecaseObservable(params: Any?): Single<StudentEntity> =
      repository.getStudent()
}