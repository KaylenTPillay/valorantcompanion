package co.za.softwareological.kaylen.feature_agent.di

import co.za.softwareological.kaylen.core_api.source.factory.SourceNetworkFactory
import co.za.softwareological.kaylen.feature_agent.api.repository.RepositoryAgent
import co.za.softwareological.kaylen.feature_agent.api.repository.impl.RepositoryAgentImpl
import co.za.softwareological.kaylen.feature_agent.api.source.network.SourceNetworkAgent
import co.za.softwareological.kaylen.feature_agent.domain.usecase.UseCaseAgentListGet
import co.za.softwareological.kaylen.feature_agent.presentation.view.ViewAgentList
import co.za.softwareological.kaylen.feature_agent.presentation.view.impl.ViewAgentListImpl
import co.za.softwareological.kaylen.feature_agent.presentation.viewmodel.impl.ViewModelAgentListImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val apiDIModule = module {
    factory { SourceNetworkFactory.generateConnector(SourceNetworkAgent::class.java) }
    factory<RepositoryAgent> { RepositoryAgentImpl(get()) }
}

private val domainDIModule = module {
    factory { UseCaseAgentListGet(get()) }
}

private val presentationDIModule = module {
    factory<ViewAgentList> { ViewAgentListImpl() }
    viewModel { ViewModelAgentListImpl(get()) }
}

val featureAgentDIModule = module {
    includes(apiDIModule, domainDIModule, presentationDIModule)
}