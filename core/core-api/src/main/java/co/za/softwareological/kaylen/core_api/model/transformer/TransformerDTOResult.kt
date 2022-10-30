package co.za.softwareological.kaylen.core_api.model.transformer

import co.za.softwareological.kaylen.core_api.model.DTOResult
import com.google.gson.Gson
import retrofit2.Response

object TransformerDTOResult {

    inline fun <reified E> Response<E>?.toDTOResult(): DTOResult<E> {
        if (this == null) return DTOResult.Failure()

        return when {
            isSuccessful -> {
                val body = body()
                if (body == null) {
                    DTOResult.Failure()
                } else {
                    DTOResult.Successful(data = body)
                }
            }
            else -> {
                DTOResult.Failure(
                    errorData = errorBody()?.string().toErrorResponse(),
                    statusCode = code(),
                    message = message()
                )
            }
        }
    }

    inline fun <reified E> String?.toErrorResponse(): E? {
        if (this == null) return null

        val gson = Gson()
        return gson.fromJson(this, E::class.java)
    }

}