package co.za.softwareological.kaylen.feature_agent.presentation.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.za.softwareological.kaylen.core_domain.model.result.EntityResult
import co.za.softwareological.kaylen.feature_agent.domain.model.request.EntityRequestAgentList
import co.za.softwareological.kaylen.feature_agent.domain.model.response.EntityResponseAgentList
import co.za.softwareological.kaylen.feature_agent.domain.usecase.UseCaseAgentListGet
import co.za.softwareological.kaylen.feature_agent.presentation.model.UIStateAgentList
import co.za.softwareological.kaylen.feature_agent.presentation.model.transformer.TransformerUIStateAgent.toUIStateAgents
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
            when (val result = useCaseAgentListGet.execute(request = EntityRequestAgentList())) {
                is EntityResult.Success -> {
                    handleOnAgentListSuccess(result)
                }
                is EntityResult.Failure -> {
                    handleOnAgentListFailed()
                }
            }
        }
    }

    private fun handleOnAgentListSuccess(result: EntityResult.Success<EntityResponseAgentList>) {
        updateState { state ->
            state.copy(agents = result.data.agents.toUIStateAgents())
        }
    }

    private fun handleOnAgentListFailed() {
        updateState { state -> state.copy(isInErrorState = true) }
    }

    private fun updateState(block: (currentState: UIStateAgentList) -> UIStateAgentList) {
        _uiStateFlow.update(block)
    }

}