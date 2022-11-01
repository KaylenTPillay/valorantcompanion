package co.za.softwareological.kaylen.feature_agent.presentation.model.transformer

import co.za.softwareological.kaylen.feature_agent.domain.model.EntityAgent
import co.za.softwareological.kaylen.feature_agent.presentation.model.UIStateAgent

internal object TransformerUIStateAgent {

    fun List<EntityAgent>.toUIStateAgents(): List<UIStateAgent> {
        return map { it.toUIStateAgent() }
    }

    private fun EntityAgent.toUIStateAgent(): UIStateAgent {
        return UIStateAgent(
            name = name,
            description = description,
            avatarUrl = avatarUrl,
            roleUrl = roleUrl
        )
    }

}