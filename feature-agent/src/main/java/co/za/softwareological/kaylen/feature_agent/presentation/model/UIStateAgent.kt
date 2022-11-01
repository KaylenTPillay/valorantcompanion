package co.za.softwareological.kaylen.feature_agent.presentation.model

internal data class UIStateAgent(
    val name: String,
    val description: String,
    val avatarUrl: String,
    val roleUrl: String
) {
    val avatarContentDescription: String = "$name avatar"
}