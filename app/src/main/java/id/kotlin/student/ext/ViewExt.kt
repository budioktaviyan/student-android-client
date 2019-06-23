package id.kotlin.student.ext

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

internal fun ViewGroup.inflate(layoutRes: Int, root: ViewGroup, attachToRoot: Boolean = false): View =
    LayoutInflater.from(this.context).inflate(layoutRes, root, attachToRoot)

internal fun View.show() {
  visibility = View.VISIBLE
}

internal fun View.hide() {
  visibility = View.GONE
}

internal fun View.showToast(any: Any) = Toast.makeText(context, any as String, Toast.LENGTH_SHORT).show()