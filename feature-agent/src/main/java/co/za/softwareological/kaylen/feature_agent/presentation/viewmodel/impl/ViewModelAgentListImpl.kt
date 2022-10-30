package co.za.softwareological.kaylen.feature_agent.presentation.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.za.softwareological.kaylen.core_domain.model.EntityResult
import co.za.softwareological.kaylen.feature_agent.domain.usecase.UseCaseAgentListGet
import co.za.softwareological.kaylen.feature_agent.presentation.model.UIStateAgentList
import co.za.softwareological.kaylen.feature_agent.presentation.viewmodel.ViewModelAgentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class ViewModelAgentListImpl(
    private val useCaseAgentListGet: UseCaseAgentListGet
) : ViewModel(), ViewModelAgentList {

    private val _uiStateFlow: MutableStateFlow<UIStateAgentList> =
        MutableStateFlow(UIStateAgentList())
    override val uiState: StateFlow<UIStateAgentList> = _uiStateFlow

    init {
        fetchAgentList()
    }

    private fun fetchAgentList() {
        viewModelScope.launch {
            when (val result = useCaseAgentListGet.execute()) {
                is EntityResult.Success -> {
                    _uiStateFlow.update { currentState ->
                        currentState.copy(testData = result.data.status.toString())
                    }
                }
                is EntityResult.Failure -> {
                    _uiStateFlow.update { currentState ->
                        currentState.copy(testData = result.statusCode.toString())
                    }
                }
            }
        }
    }

}