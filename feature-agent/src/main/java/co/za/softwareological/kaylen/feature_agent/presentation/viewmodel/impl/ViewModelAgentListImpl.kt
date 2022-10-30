package co.za.softwareological.kaylen.feature_agent.presentation.viewmodel.impl

import androidx.lifecycle.ViewModel
import co.za.softwareological.kaylen.feature_agent.domain.usecase.UseCaseAgentListGet
import co.za.softwareological.kaylen.feature_agent.presentation.model.UIStateAgentList
import co.za.softwareological.kaylen.feature_agent.presentation.viewmodel.ViewModelAgentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class ViewModelAgentListImpl(
    private val useCaseAgentListGet: UseCaseAgentListGet
) : ViewModel(), ViewModelAgentList {

    private val _uiStateFlow: MutableStateFlow<UIStateAgentList> =
        MutableStateFlow(UIStateAgentList())
    override val uiState: StateFlow<UIStateAgentList> = _uiStateFlow

    override fun onInit() {
    }

}