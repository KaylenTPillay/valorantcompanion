package co.za.softwareological.kaylen.feature_agent.presentation.viewmodel

import co.za.softwareological.kaylen.feature_agent.presentation.model.UIStateAgentList
import kotlinx.coroutines.flow.StateFlow

interface ViewModelAgentList {

    val uiState: StateFlow<UIStateAgentList>

    fun onInit()

}