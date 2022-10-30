package co.za.softwareological.kaylen.feature_agent.api.repository.impl

import co.za.softwareological.kaylen.feature_agent.api.model.request.DTORequestAgentList
import co.za.softwareological.kaylen.feature_agent.api.repository.RepositoryAgent

internal class RepositoryAgentImpl : RepositoryAgent {

    override suspend fun getAgentList(request: DTORequestAgentList) {
        // TODO(1): Implement getAgentList request.
    }

}