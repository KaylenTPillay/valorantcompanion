package co.za.softwareological.kaylen.feature_agent.presentation.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.za.softwareological.kaylen.feature_agent.domain.usecase.factory.UseCaseFactoryAgentListGet
import co.za.softwareological.kaylen.feature_agent.presentation.viewmodel.impl.ViewModelAgentListImpl

@Suppress("UNCHECKED_CAST")
internal class ViewModelFactoryAgentList : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelAgentListImpl::class.java)) {
            return ViewModelAgentListImpl(UseCaseFactoryAgentListGet.create()) as T
        }

        throw IllegalStateException("ViewModelAgentList not available")
    }

}