package co.za.softwareological.kaylen.feature_agent.api.repository.impl

import co.za.softwareological.kaylen.core_api.model.DTOResult
import co.za.softwareological.kaylen.feature_agent.api.model.request.DTORequestAgentList
import co.za.softwareological.kaylen.feature_agent.api.model.response.DTOResponseAgentList
import co.za.softwareological.kaylen.feature_agent.api.repository.RepositoryAgent
import co.za.softwareological.kaylen.feature_agent.api.source.network.SourceNetworkAgent

internal class RepositoryAgentImpl(
    private val sourceNetworkAgent: SourceNetworkAgent?
) : RepositoryAgent {

    override suspend fun getAgentList(request: DTORequestAgentList): DTOResult<DTOResponseAgentList> {
        val response = sourceNetworkAgent?.getAgentList(request.getParamMap())
        return DTOResult.Failure()
    }

}