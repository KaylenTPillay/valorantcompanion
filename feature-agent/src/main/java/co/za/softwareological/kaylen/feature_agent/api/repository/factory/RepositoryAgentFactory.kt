package co.za.softwareological.kaylen.feature_agent.api.repository.factory

import co.za.softwareological.kaylen.core_api.source.factory.SourceNetworkFactory
import co.za.softwareological.kaylen.feature_agent.api.repository.RepositoryAgent
import co.za.softwareological.kaylen.feature_agent.api.repository.impl.RepositoryAgentImpl
import co.za.softwareological.kaylen.feature_agent.api.source.network.SourceNetworkAgent

internal object RepositoryAgentFactory {

    fun create(): RepositoryAgent {
        return RepositoryAgentImpl(
            SourceNetworkFactory.generateConnector(SourceNetworkAgent::class.java)
        )
    }

}