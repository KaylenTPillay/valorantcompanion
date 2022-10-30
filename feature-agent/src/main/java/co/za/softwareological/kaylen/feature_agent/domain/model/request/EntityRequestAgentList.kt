package co.za.softwareological.kaylen.feature_agent.domain.model.request

internal data class EntityRequestAgentList(
    val lang: String = DEFAULT_LANGUAGE,
    val isPlayableCharacter: Boolean = DEFAULT_IS_PLAYABLE_CHARACTER
) {

    companion object {
        const val DEFAULT_LANGUAGE: String = "en-US"
        const val DEFAULT_IS_PLAYABLE_CHARACTER: Boolean = true
    }

}