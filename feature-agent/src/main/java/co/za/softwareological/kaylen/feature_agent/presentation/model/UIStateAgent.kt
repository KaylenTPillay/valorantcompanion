package co.za.softwareological.kaylen.feature_agent.presentation.model

internal data class UIStateAgent(
    val name: String,
    val description: String,
    val avatarUrl: String,
    val roleUrl: String,
    val isSelected: Boolean = false
) {
    val avatarContentDescription: String = "$name avatar"

    companion object {
        fun createDefault(): UIStateAgent {
            return UIStateAgent(name = "", description = "", avatarUrl = "", roleUrl = "")
        }
    }
}