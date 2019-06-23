package id.kotlin.student.core.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import javax.inject.Inject

abstract class Activity<V : View, P : Presenter<V>> : AppCompatActivity() {

  @Inject lateinit var presenter: P

  @Suppress("UNCHECKED_CAST")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter.onAttach(this as V)
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.onDetach()
  }
}