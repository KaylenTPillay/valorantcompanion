package co.za.softwareological.kaylen.feature_agent.api.model.response

import co.za.softwareological.kaylen.feature_agent.api.model.DTOAgentData

internal data class DTOResponseAgentList(
    val status: Int? = null,
    val data: List<DTOAgentData>? = null
)