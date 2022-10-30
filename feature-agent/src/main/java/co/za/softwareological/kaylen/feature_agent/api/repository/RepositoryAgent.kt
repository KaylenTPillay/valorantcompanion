package co.za.softwareological.kaylen.feature_agent.api.repository

import co.za.softwareological.kaylen.core_api.model.DTOResult
import co.za.softwareological.kaylen.feature_agent.api.model.request.DTORequestAgentList
import co.za.softwareological.kaylen.feature_agent.api.model.response.DTOResponseAgentList

internal interface RepositoryAgent {

    suspend fun getAgentList(request: DTORequestAgentList): DTOResult<DTOResponseAgentList>

}