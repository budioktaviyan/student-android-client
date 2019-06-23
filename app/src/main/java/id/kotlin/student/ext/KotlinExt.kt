package id.kotlin.student.ext

import id.kotlin.student.core.data.Response
import org.json.JSONObject
import retrofit2.HttpException

internal inline fun <reified T : Any> clazz() = T::class.java

internal fun Throwable.response(): Response {
  val httpException = this as? HttpException
  return when (httpException?.code()) {
    404 -> Response("Terjadi kesalahan!")
    else -> {
      val message = httpException?.response()?.errorBody()?.let { response ->
        val json = response.source().readUtf8().toString()
        JSONObject(json).getString("message")
      }

      Response(message ?: "Koneksi gagal")
    }
  }
}