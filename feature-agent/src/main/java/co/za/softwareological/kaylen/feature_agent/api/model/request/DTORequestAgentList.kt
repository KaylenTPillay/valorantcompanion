package co.za.softwareological.kaylen.feature_agent.api.model.request

internal data class DTORequestAgentList(
    val language: String,
    val isPlayableCharacter: Boolean
) {

    fun getParamMap(): Map<String, String> {
        return buildMap {
            put("language", language)
            put("isPlayableCharacter", isPlayableCharacter.toString())
        }
    }

}