package co.za.softwareological.kaylen.feature_agent.presentation.view.impl

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import co.za.softwareological.kaylen.feature_agent.presentation.view.ViewAgentList
import co.za.softwareological.kaylen.feature_agent.presentation.viewmodel.ViewModelAgentList
import co.za.softwareological.kaylen.feature_agent.presentation.viewmodel.factory.ViewModelFactoryAgentList

internal class ViewAgentListImpl : ViewAgentList {

    @Composable
    override fun RenderScreen() {
        val viewModel: ViewModelAgentList = viewModel(factory = ViewModelFactoryAgentList())
        val uiState by viewModel.uiState.collectAsState()

        Text(uiState.testData)
    }

}