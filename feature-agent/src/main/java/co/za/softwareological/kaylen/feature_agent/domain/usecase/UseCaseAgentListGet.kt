package co.za.softwareological.kaylen.feature_agent.domain.usecase

import co.za.softwareological.kaylen.core_domain.model.result.EntityResult
import co.za.softwareological.kaylen.core_domain.model.transformer.TransformerEntityResult.toEntityResult
import co.za.softwareological.kaylen.core_domain.usecase.UseCase
import co.za.softwareological.kaylen.feature_agent.api.repository.RepositoryAgent
import co.za.softwareological.kaylen.feature_agent.domain.model.request.EntityRequestAgentList
import co.za.softwareological.kaylen.feature_agent.domain.model.request.transformer.TransformerEntityRequestAgentList.toDTORequestAgentList
import co.za.softwareological.kaylen.feature_agent.domain.model.response.EntityResponseAgentList
import co.za.softwareological.kaylen.feature_agent.domain.model.response.transformer.TransformerEntityResponseEntityAgentList.toEntityResponseAgentList

internal class UseCaseAgentListGet(
    private val repository: RepositoryAgent
) : UseCase<EntityResponseAgentList>() {

    override suspend fun onExecuteWithUseCaseContext(
        request: Any?
    ): EntityResult<EntityResponseAgentList> {
        if (request !is EntityRequestAgentList) return invalidRequestResult

        val dtoResult = repository.getAgentList(request.toDTORequestAgentList())
        return dtoResult.toEntityResult { response -> response.toEntityResponseAgentList() }
    }

}