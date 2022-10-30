package co.za.softwareological.kaylen.core_api.model

sealed class DTOResult<E> {

    data class Successful<E>(val data: E) : DTOResult<E>()

    data class Failure<E>(
        val errorData: E? = null,
        val statusCode: Int = -1,
        val exception: Throwable? = null
    ) : DTOResult<E>()

}