package co.za.softwareological.kaylen.feature_agent.domain.model.response.transformer

import co.za.softwareological.kaylen.feature_agent.api.model.response.DTOResponseAgentList
import co.za.softwareological.kaylen.feature_agent.domain.model.EntityAgent
import co.za.softwareological.kaylen.feature_agent.domain.model.response.EntityResponseAgentList

internal object TransformerEntityResponseEntityAgentList {

    fun DTOResponseAgentList?.toEntityResponseAgentList(): EntityResponseAgentList {
        if (this == null) return EntityResponseAgentList()

        return EntityResponseAgentList(
            status = this@toEntityResponseAgentList.status ?: EntityResponseAgentList.DEFAULT_STATUS,
            agents = this@toEntityResponseAgentList.data?.map { agentData ->
                EntityAgent(
                    name = agentData.displayName ?: EntityAgent.DEFAULT_NAME,
                    description = agentData.description ?: EntityAgent.DEFAULT_DESCRIPTION
                )
            } ?: emptyList()
        )
    }

}