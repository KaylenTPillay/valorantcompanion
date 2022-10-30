package co.za.softwareological.kaylen.feature_agent.domain.model.response

import co.za.softwareological.kaylen.feature_agent.domain.model.EntityAgent

internal data class EntityResponseAgentList(
    val status: Int = DEFAULT_STATUS,
    val agents: List<EntityAgent> = emptyList()
) {

    companion object {
        const val DEFAULT_STATUS = -1
    }

}