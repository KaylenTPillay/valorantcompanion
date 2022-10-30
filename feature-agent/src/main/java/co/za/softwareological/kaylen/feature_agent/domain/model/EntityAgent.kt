package co.za.softwareological.kaylen.feature_agent.domain.model

data class EntityAgent(
    val name: String = DEFAULT_NAME,
    val description: String = DEFAULT_DESCRIPTION
) {

    companion object {
        const val DEFAULT_NAME: String = ""
        const val DEFAULT_DESCRIPTION: String = ""
    }

}