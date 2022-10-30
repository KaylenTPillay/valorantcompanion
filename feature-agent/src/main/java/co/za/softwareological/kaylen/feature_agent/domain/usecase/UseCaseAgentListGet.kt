package co.za.softwareological.kaylen.feature_agent.domain.usecase

import co.za.softwareological.kaylen.feature_agent.api.repository.RepositoryAgent
import co.za.softwareological.kaylen.feature_agent.domain.model.request.EntityRequestAgentList
import co.za.softwareological.kaylen.feature_agent.domain.model.request.transformer.TransformerEntityRequestAgentList.toDTORequestAgentList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class UseCaseAgentListGet(
    private val repository: RepositoryAgent
) {

    suspend fun execute(request: EntityRequestAgentList) {
        withContext(Dispatchers.IO) {
            val result = repository.getAgentList(request.toDTORequestAgentList())
        }
    }

}