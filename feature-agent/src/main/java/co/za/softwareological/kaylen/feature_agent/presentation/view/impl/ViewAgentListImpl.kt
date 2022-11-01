package co.za.softwareological.kaylen.feature_agent.presentation.view.impl

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import co.za.softwareological.kaylen.feature_agent.presentation.model.UIStateAgent
import co.za.softwareological.kaylen.feature_agent.presentation.view.ViewAgentList
import co.za.softwareological.kaylen.feature_agent.presentation.viewmodel.ViewModelAgentList
import co.za.softwareological.kaylen.feature_agent.presentation.viewmodel.factory.ViewModelFactoryAgentList
import coil.compose.AsyncImage

internal class ViewAgentListImpl : ViewAgentList {

    @Composable
    override fun RenderScreen() {
        val viewModel: ViewModelAgentList = viewModel(factory = ViewModelFactoryAgentList())
        val uiState by viewModel.uiState.collectAsState()

        when {
            uiState.isInErrorState -> ErrorState()
            else -> AgentList(agents = uiState.agents)
        }
    }

    @Composable
    private fun ErrorState() {
    }

    @Composable
    private fun AgentList(agents: List<UIStateAgent>) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(items = agents) { agent ->
                Agent(agent = agent)
            }
        }
    }

    @Composable
    private fun Agent(agent: UIStateAgent) {
        Card {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AgentAvatar(agent = agent)
                Spacer(modifier = Modifier.size(8.dp))
                Column {
                    AgentName(agent = agent)
                    Text(text = agent.description)
                }
            }
        }
    }

    @Composable
    private fun AgentAvatar(agent: UIStateAgent) {
        AsyncImage(
            model = agent.avatarUrl,
            contentDescription = agent.avatarContentDescription,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )
    }

    @Composable
    private fun AgentName(agent: UIStateAgent) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = agent.roleUrl,
                contentDescription = "Test",
                colorFilter = ColorFilter.tint(Color.DarkGray),
                filterQuality = FilterQuality.High,
                modifier = Modifier
                    .size(16.dp)
                    .border(
                        BorderStroke(1.dp, Color.LightGray),
                        CircleShape
                    )
                    .padding(2.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = agent.name)
        }
    }

    @Preview(showBackground = true)
    @Composable
    private fun PreviewAgent() {
        val previewAgent = UIStateAgent(
            name = "Fade",
            description = "Turkish bounty hunter Fade unleashes the power of raw nightmare to seize enemy secrets. Attuned with terror itself, she hunts down targets and reveals their deepest fears - before crushing them in the dark.",
            avatarUrl = "https://media.valorant-api.com/agents/dade69b4-4f5a-8528-247b-219e5a1facd6/displayiconsmall.png",
            roleUrl = "https://media.valorant-api.com/agents/roles/1b47567f-8f7b-444b-aae3-b0c634622d10/displayicon.png"
        )
        Agent(agent = previewAgent)
    }

}