package co.za.softwareological.kaylen.feature_agent.domain.usecase

import co.za.softwareological.kaylen.core_domain.model.EntityResult
import co.za.softwareological.kaylen.feature_agent.domain.model.request.EntityRequestAgentList
import co.za.softwareological.kaylen.feature_agent.domain.model.response.EntityResponseAgentList

internal interface UseCaseAgentListGet {

    suspend fun execute(request: EntityRequestAgentList): EntityResult<EntityResponseAgentList>

}