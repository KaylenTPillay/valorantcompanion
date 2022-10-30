package co.za.softwareological.kaylen.feature_agent.api.model

internal data class DTOAgentVoiceLine(
    val minDuration: Double? = null,
    val maxDuration: Double? = null,
    val mediaList: List<DTOAgentVoiceLineMediaList>? = null
)