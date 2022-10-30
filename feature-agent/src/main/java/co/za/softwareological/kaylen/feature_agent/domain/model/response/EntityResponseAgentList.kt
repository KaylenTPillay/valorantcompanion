package co.za.softwareological.kaylen.feature_agent.domain.model.response

internal data class EntityResponseAgentList(
    val status: Int = DEFAULT_STATUS
) {

    companion object {
        const val DEFAULT_STATUS = -1
    }

}