package co.za.softwareological.kaylen.feature_agent.api.model.request

internal data class DTORequestAgentList(
    val language: String = DEFAULT_LANGUAGE,
    val isPlayableCharacter: Boolean = DEFAULT_IS_PLAYABLE_CHARACTER
) {
    companion object {
        const val DEFAULT_LANGUAGE: String = "en-US"
        const val DEFAULT_IS_PLAYABLE_CHARACTER: Boolean = true
    }
}