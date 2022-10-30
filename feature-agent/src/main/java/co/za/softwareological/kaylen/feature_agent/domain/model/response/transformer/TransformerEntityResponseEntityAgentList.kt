package co.za.softwareological.kaylen.feature_agent.domain.model.response.transformer

import co.za.softwareological.kaylen.feature_agent.api.model.response.DTOResponseAgentList
import co.za.softwareological.kaylen.feature_agent.domain.model.response.EntityResponseAgentList

internal object TransformerEntityResponseEntityAgentList {

    fun DTOResponseAgentList?.toEntityResponseAgentList(): EntityResponseAgentList {
        if (this == null) return EntityResponseAgentList()

        return EntityResponseAgentList(
            status = this@toEntityResponseAgentList.status ?: EntityResponseAgentList.DEFAULT_STATUS
        )
    }

}