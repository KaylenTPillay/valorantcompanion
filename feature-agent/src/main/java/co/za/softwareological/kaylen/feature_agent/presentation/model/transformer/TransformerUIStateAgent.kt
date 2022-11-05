package co.za.softwareological.kaylen.feature_agent.presentation.model.transformer

import co.za.softwareological.kaylen.feature_agent.domain.model.EntityAgent
import co.za.softwareological.kaylen.feature_agent.presentation.model.UIStateAgent

internal object TransformerUIStateAgent {

    fun List<EntityAgent>.toUIStateAgents(): List<UIStateAgent> {
        return mapIndexed { index, entityAgent ->
            entityAgent.toUIStateAgent(isSelected = index == 0)
        }
    }

    private fun EntityAgent.toUIStateAgent(isSelected: Boolean): UIStateAgent {
        return UIStateAgent(
            name = name,
            description = description,
            avatarUrl = avatarUrl,
            roleUrl = roleUrl,
            isSelected = isSelected
        )
    }

}