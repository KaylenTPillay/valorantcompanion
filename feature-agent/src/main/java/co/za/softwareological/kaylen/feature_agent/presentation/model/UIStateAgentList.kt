package co.za.softwareological.kaylen.feature_agent.presentation.model

internal data class UIStateAgentList(
    val isInErrorState: Boolean = false,
    val agents: List<UIStateAgent> = emptyList()
)