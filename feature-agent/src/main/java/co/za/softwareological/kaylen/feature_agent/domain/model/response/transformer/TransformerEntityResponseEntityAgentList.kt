package co.za.softwareological.kaylen.feature_agent.domain.model.response.transformer

import co.za.softwareological.kaylen.core_util.defaults.UtilDefaults
import co.za.softwareological.kaylen.feature_agent.api.model.DTOAgentData
import co.za.softwareological.kaylen.feature_agent.api.model.response.DTOResponseAgentList
import co.za.softwareological.kaylen.feature_agent.domain.model.EntityAgent
import co.za.softwareological.kaylen.feature_agent.domain.model.response.EntityResponseAgentList

internal object TransformerEntityResponseEntityAgentList {

    fun DTOResponseAgentList?.toEntityResponseAgentList(): EntityResponseAgentList {
        if (this == null) return EntityResponseAgentList()

        return EntityResponseAgentList(
            status = this@toEntityResponseAgentList.status ?: EntityResponseAgentList.DEFAULT_STATUS,
            agents = this@toEntityResponseAgentList.data?.map { agentData ->
                agentData.toEntityAgent()
            } ?: emptyList()
        )
    }

    private fun DTOAgentData.toEntityAgent(): EntityAgent {
        return EntityAgent(
            name = displayName ?: UtilDefaults.DEFAULT_STRING,
            description = description ?: UtilDefaults.DEFAULT_STRING,
            avatarUrl = displayIconSmall ?: UtilDefaults.DEFAULT_STRING,
            roleUrl = role?.displayIcon ?: UtilDefaults.DEFAULT_STRING
        )
    }

}