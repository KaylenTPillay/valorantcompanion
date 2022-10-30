package co.za.softwareological.kaylen.feature_agent.domain.usecase.factory

import co.za.softwareological.kaylen.feature_agent.api.repository.factory.RepositoryAgentFactory
import co.za.softwareological.kaylen.feature_agent.domain.usecase.UseCaseAgentListGet
import co.za.softwareological.kaylen.feature_agent.domain.usecase.impl.UseCaseAgentListGetImpl

internal object UseCaseFactoryAgentListGet {

    fun create(): UseCaseAgentListGet {
        return UseCaseAgentListGetImpl(repository = RepositoryAgentFactory.create())
    }

}