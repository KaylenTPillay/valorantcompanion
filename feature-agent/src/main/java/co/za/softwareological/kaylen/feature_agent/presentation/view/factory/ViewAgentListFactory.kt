package co.za.softwareological.kaylen.feature_agent.presentation.view.factory

import co.za.softwareological.kaylen.feature_agent.presentation.view.ViewAgentList
import co.za.softwareological.kaylen.feature_agent.presentation.view.impl.ViewAgentListImpl

object ViewAgentListFactory {

    fun create(): ViewAgentList {
        return ViewAgentListImpl()
    }

}