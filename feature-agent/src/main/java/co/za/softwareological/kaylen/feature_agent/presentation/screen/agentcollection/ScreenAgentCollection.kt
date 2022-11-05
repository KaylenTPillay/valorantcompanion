package co.za.softwareological.kaylen.feature_agent.presentation.screen.agentcollection

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.za.softwareological.kaylen.feature_agent.presentation.model.UIStateAgent
import coil.compose.AsyncImage

@Composable
internal fun AgentCollectionScreen(
    agents: List<UIStateAgent>,
    showExpandedDetail: Boolean,
    state: LazyListState,
    onAgentClick: (UIStateAgent) -> Unit
) {
    LazyColumn(
        state = state,
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(items = agents) { agent ->
            Agent(
                agent = agent,
                showExpandedDetail = showExpandedDetail,
                onAgentClick = onAgentClick
            )
        }
    }
}

@Composable
private fun Agent(
    agent: UIStateAgent,
    showExpandedDetail: Boolean,
    onAgentClick: (UIStateAgent) -> Unit
) {
    val shouldShowBorder = !showExpandedDetail && agent.isSelected
    Card(
        modifier = Modifier.clickable { onAgentClick.invoke(agent) },
        border = if (shouldShowBorder) BorderStroke(1.dp, Color.Cyan) else null
    ) {
        if (showExpandedDetail) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AgentContent(agent = agent, showExpandedDetail = true)
            }
        } else {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AgentContent(agent = agent, showExpandedDetail = false)
            }
        }
    }
}

@Composable
private fun AgentContent(agent: UIStateAgent, showExpandedDetail: Boolean) {
    AgentAvatar(agent = agent)
    Spacer(modifier = Modifier.size(8.dp))
    if (showExpandedDetail) {
        Column {
            AgentName(agent = agent)
            Text(text = agent.description)
        }
    } else {
        AgentName(agent = agent)
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
private fun PreviewExpandedAgent() {
    val previewAgent = UIStateAgent(
        name = "Fade",
        description = "Turkish bounty hunter Fade unleashes the power of raw nightmare to seize enemy secrets. Attuned with terror itself, she hunts down targets and reveals their deepest fears - before crushing them in the dark.",
        avatarUrl = "https://media.valorant-api.com/agents/dade69b4-4f5a-8528-247b-219e5a1facd6/displayiconsmall.png",
        roleUrl = "https://media.valorant-api.com/agents/roles/1b47567f-8f7b-444b-aae3-b0c634622d10/displayicon.png"
    )
    Agent(agent = previewAgent, showExpandedDetail = true, onAgentClick = {})
}

@Preview(showBackground = true)
@Composable
private fun PreviewUnexpandedAgent() {
    val previewAgent = UIStateAgent(
        name = "Fade",
        description = "Turkish bounty hunter Fade unleashes the power of raw nightmare to seize enemy secrets. Attuned with terror itself, she hunts down targets and reveals their deepest fears - before crushing them in the dark.",
        avatarUrl = "https://media.valorant-api.com/agents/dade69b4-4f5a-8528-247b-219e5a1facd6/displayiconsmall.png",
        roleUrl = "https://media.valorant-api.com/agents/roles/1b47567f-8f7b-444b-aae3-b0c634622d10/displayicon.png"
    )
    Agent(agent = previewAgent, showExpandedDetail = false, onAgentClick = {})
}