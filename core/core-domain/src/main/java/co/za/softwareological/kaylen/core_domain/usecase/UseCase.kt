package co.za.softwareological.kaylen.core_domain.usecase

import co.za.softwareological.kaylen.core_domain.model.result.EntityResult
import co.za.softwareological.kaylen.core_domain.usecase.exception.InvalidRequestException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class UseCase<RESPONSE> {

    protected val invalidRequestResult =
        EntityResult.Failure<RESPONSE>(exception = InvalidRequestException())

    suspend fun execute(request: Any? = null): EntityResult<RESPONSE> {
        return withUseCaseContext {
            onExecuteWithUseCaseContext(request)
        }
    }

    protected abstract suspend fun onExecuteWithUseCaseContext(
        request: Any?
    ): EntityResult<RESPONSE>

    private suspend fun withUseCaseContext(
        block: suspend CoroutineScope.() -> EntityResult<RESPONSE>
    ): EntityResult<RESPONSE> {
        return try {
            withContext(Dispatchers.IO) {
                block()
            }
        } catch (e: Exception) {
            EntityResult.Failure(exception = e)
        }
    }

}