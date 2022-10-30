package co.za.softwareological.kaylen.feature_agent.domain.usecase.impl

import co.za.softwareological.kaylen.core_domain.model.EntityResult
import co.za.softwareological.kaylen.core_domain.model.transformer.TransformerEntityResult.toEntityResult
import co.za.softwareological.kaylen.feature_agent.api.repository.RepositoryAgent
import co.za.softwareological.kaylen.feature_agent.domain.model.request.EntityRequestAgentList
import co.za.softwareological.kaylen.feature_agent.domain.model.request.transformer.TransformerEntityRequestAgentList.toDTORequestAgentList
import co.za.softwareological.kaylen.feature_agent.domain.model.response.EntityResponseAgentList
import co.za.softwareological.kaylen.feature_agent.domain.model.response.transformer.TransformerEntityResponseEntityAgentList.toEntityResponseAgentList
import co.za.softwareological.kaylen.feature_agent.domain.usecase.UseCaseAgentListGet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class UseCaseAgentListGetImpl(
    private val repository: RepositoryAgent
) : UseCaseAgentListGet {

    override suspend fun execute(
        request: EntityRequestAgentList
    ): EntityResult<EntityResponseAgentList> {
        return withContext(Dispatchers.IO) {
            val result = repository.getAgentList(request.toDTORequestAgentList())
            result.toEntityResult { response -> response.toEntityResponseAgentList() }
        }
    }

}