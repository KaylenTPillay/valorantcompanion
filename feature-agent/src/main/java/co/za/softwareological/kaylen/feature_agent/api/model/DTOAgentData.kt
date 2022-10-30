package co.za.softwareological.kaylen.feature_agent.api.model

internal data class DTOAgentData(
    val uuid: String? = null,
    val displayName: String? = null,
    val description: String? = null,
    val developerName: String? = null,
    val characterTags: List<String>? = null,
    val displayIcon: String? = null,
    val displayIconSmall: String? = null,
    val bustPortrait: String? = null,
    val fullPortrait: String? = null,
    val fullPortraitV2: String? = null,
    val killfeedPortrait: String? = null,
    val background: String? = null,
    val backgroundGradientColors: List<String>? = null,
    val assetPath: String? = null,
    val isFullPortraitRightFacing: Boolean? = null,
    val isPlayableCharacter: Boolean? = null,
    val isAvailableForTest: Boolean? = null,
    val isBaseContent: Boolean? = null,
    val role: DTOAgentRole? = null,
    val abilities: List<DTOAgentAbility>? = null,
    val voiceLine: DTOAgentVoiceLine? = null
)