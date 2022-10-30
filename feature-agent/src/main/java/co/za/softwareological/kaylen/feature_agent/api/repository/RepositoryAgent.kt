package co.za.softwareological.kaylen.feature_agent.api.repository

import co.za.softwareological.kaylen.feature_agent.api.model.request.DTORequestAgentList

internal interface RepositoryAgent {

    suspend fun getAgentList(request: DTORequestAgentList)

}