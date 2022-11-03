package co.za.softwareological.kaylen.feature_agent.di

import co.za.softwareological.kaylen.core_api.source.factory.SourceNetworkFactory
import co.za.softwareological.kaylen.feature_agent.api.repository.RepositoryAgent
import co.za.softwareological.kaylen.feature_agent.api.repository.impl.RepositoryAgentImpl
import co.za.softwareological.kaylen.feature_agent.api.source.network.SourceNetworkAgent
import co.za.softwareological.kaylen.feature_agent.domain.usecase.UseCaseAgentListGet
import co.za.softwareological.kaylen.feature_agent.presentation.viewmodel.impl.ViewModelAgentListImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DIFeatureAgent {
    val modules = module {
        factory { SourceNetworkFactory.generateConnector(SourceNetworkAgent::class.java) }
        factory<RepositoryAgent> { RepositoryAgentImpl(get()) }
        factory { UseCaseAgentListGet(get()) }
        viewModel { ViewModelAgentListImpl(get()) }
    }
}