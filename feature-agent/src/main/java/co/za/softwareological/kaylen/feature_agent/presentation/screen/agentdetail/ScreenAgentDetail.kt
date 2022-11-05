package co.za.softwareological.kaylen.feature_agent.presentation.screen.agentdetail

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import co.za.softwareological.kaylen.feature_agent.presentation.model.UIStateAgent

@Composable
internal fun AgentDetailScreen(
    agent: UIStateAgent,
    state: LazyListState
) {
    Text(text = agent.name)
}