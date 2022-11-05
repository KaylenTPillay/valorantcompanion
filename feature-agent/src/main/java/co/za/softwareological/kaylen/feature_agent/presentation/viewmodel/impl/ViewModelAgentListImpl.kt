package co.za.softwareological.kaylen.feature_agent.presentation.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.za.softwareological.kaylen.core_domain.model.result.EntityResult
import co.za.softwareological.kaylen.feature_agent.domain.model.request.EntityRequestAgentList
import co.za.softwareological.kaylen.feature_agent.domain.model.response.EntityResponseAgentList
import co.za.softwareological.kaylen.feature_agent.domain.usecase.UseCaseAgentListGet
import co.za.softwareological.kaylen.feature_agent.presentation.model.UIStateAgent
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

    override fun onAgentSelected(agent: UIStateAgent) {
        updateState { state ->
            state.copy(
                selectedAgent = agent,
                agents = state.agents.map { uiStateAgent ->
                    uiStateAgent.copy(isSelected = uiStateAgent == agent)
                }
            )
        }
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
        val agentsList = result.data.agents.toUIStateAgents()
        updateState { state ->
            state.copy(
                agents = agentsList,
                selectedAgent = agentsList.find { agent -> agent.isSelected } ?: state.selectedAgent
            )
        }
    }

    private fun handleOnAgentListFailed() {
        updateState { state -> state.copy(isInErrorState = true) }
    }

    private fun updateState(block: (currentState: UIStateAgentList) -> UIStateAgentList) {
        _uiStateFlow.update(block)
    }

}