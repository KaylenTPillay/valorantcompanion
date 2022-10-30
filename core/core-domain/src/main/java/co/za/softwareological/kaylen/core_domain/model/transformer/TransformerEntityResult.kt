package co.za.softwareological.kaylen.core_domain.model.transformer

import co.za.softwareological.kaylen.core_api.model.DTOResult
import co.za.softwareological.kaylen.core_domain.model.EntityResult

object TransformerEntityResult {

    fun <D, E> DTOResult<D>.toEntityResult(
        responseTransformer: (dto: D?) -> E
    ): EntityResult<E> {
        return when (this) {
            is DTOResult.Successful -> {
                EntityResult.Success(data = responseTransformer(this.data))
            }
            is DTOResult.Failure -> {
                EntityResult.Failure(
                    errorData = responseTransformer(this.errorData),
                    statusCode = this.statusCode,
                    message = this.message,
                    exception = this.exception
                )
            }
        }
    }

}