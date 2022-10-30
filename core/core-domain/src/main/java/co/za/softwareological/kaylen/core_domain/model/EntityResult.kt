package co.za.softwareological.kaylen.core_domain.model

sealed class EntityResult<E> {

    data class Success<E>(val data: E) : EntityResult<E>()

    data class Failure<E>(
        val errorData: E? = null,
        val statusCode: Int = -1,
        val message: String = String(),
        val exception: Throwable? = null
    ) : EntityResult<E>()

}