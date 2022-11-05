package co.za.softwareological.kaylen.feature_agent.presentation.view.impl

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.za.softwareological.kaylen.feature_agent.presentation.model.UIStateAgent
import co.za.softwareological.kaylen.feature_agent.presentation.model.UIStateAgentList
import co.za.softwareological.kaylen.feature_agent.presentation.model.navigationconfig.UIStateAgentListNavigationConfig
import co.za.softwareological.kaylen.feature_agent.presentation.screen.agentcollection.AgentCollectionScreen
import co.za.softwareological.kaylen.feature_agent.presentation.screen.agentdetail.AgentDetailScreen
import co.za.softwareological.kaylen.feature_agent.presentation.view.ViewAgentList
import co.za.softwareological.kaylen.feature_agent.presentation.viewmodel.impl.ViewModelAgentListImpl
import org.koin.androidx.compose.koinViewModel

internal class ViewAgentListImpl : ViewAgentList {

    @Composable
    override fun RenderScreen(shouldShowDuelPane: Boolean) {
        val viewModel = koinViewModel<ViewModelAgentListImpl>()
        val uiState by viewModel.uiState.collectAsState()

        when {
            uiState.isInErrorState -> ErrorState()
            uiState.isInEmptyState -> EmptyState()
            else -> AgentListScreen(
                shouldShowDuelPane = shouldShowDuelPane,
                uiState = uiState
            ) { agent ->
                viewModel.onAgentSelected(agent)
            }
        }
    }

    @Composable
    private fun ErrorState() {
    }

    @Composable
    private fun EmptyState() {
    }

    @Composable
    private fun AgentListScreen(
        shouldShowDuelPane: Boolean,
        uiState: UIStateAgentList,
        onAgentClick: (UIStateAgent) -> Unit
    ) {
        val agentCollectionScrollState = rememberLazyListState()
        val agentDetailScrollState = rememberLazyListState()
        if (shouldShowDuelPane) {
            AgentListDuelPane(
                uiState = uiState,
                scrollStateAgentCollection = agentCollectionScrollState,
                scrollStateAgentDetail = agentDetailScrollState,
                onAgentClick = onAgentClick
            )
        } else {
            AgentListSinglePane(
                uiState = uiState,
                scrollStateAgentCollection = agentCollectionScrollState,
                scrollStateAgentDetail = agentDetailScrollState,
                onAgentClick = onAgentClick
            )
        }
    }

    @Composable
    private fun AgentListDuelPane(
        uiState: UIStateAgentList,
        scrollStateAgentCollection: LazyListState,
        scrollStateAgentDetail: LazyListState,
        onAgentClick: (UIStateAgent) -> Unit
    ) {
        Row {
            Column {
                AgentCollectionScreen(
                    agents = uiState.agents,
                    showExpandedDetail = false,
                    state = scrollStateAgentCollection,
                    onAgentClick = onAgentClick
                )
            }
            Column {
                AgentDetailScreen(
                    agent = uiState.selectedAgent,
                    state = scrollStateAgentDetail
                )
            }
        }
    }

    @Composable
    private fun AgentListSinglePane(
        uiState: UIStateAgentList,
        scrollStateAgentCollection: LazyListState,
        scrollStateAgentDetail: LazyListState,
        onAgentClick: (UIStateAgent) -> Unit
    ) {
        val navigationController = rememberNavController()
        NavHost(
            navController = navigationController,
            startDestination = UIStateAgentListNavigationConfig.AGENT_COLLECTION
        ) {
            composable(UIStateAgentListNavigationConfig.AGENT_COLLECTION) {
                AgentCollectionScreen(
                    agents = uiState.agents,
                    showExpandedDetail = true,
                    state = scrollStateAgentCollection
                ) { agent ->
                    onAgentClick.invoke(agent)
                    navigationController.navigate(UIStateAgentListNavigationConfig.AGENT_DETAIL)
                }
            }
            composable(UIStateAgentListNavigationConfig.AGENT_DETAIL) {
                AgentDetailScreen(agent = uiState.selectedAgent, state = scrollStateAgentDetail)
            }
        }
    }

}