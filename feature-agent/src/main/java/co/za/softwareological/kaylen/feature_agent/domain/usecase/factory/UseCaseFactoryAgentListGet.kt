package co.za.softwareological.kaylen.feature_agent.domain.usecase.factory

import co.za.softwareological.kaylen.feature_agent.api.repository.factory.RepositoryAgentFactory
import co.za.softwareological.kaylen.feature_agent.domain.usecase.UseCaseAgentListGet

internal object UseCaseFactoryAgentListGet {

    fun create(): UseCaseAgentListGet {
        return UseCaseAgentListGet(repository = RepositoryAgentFactory.create())
    }

}