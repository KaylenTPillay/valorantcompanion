package co.za.softwareological.kaylen.feature_agent.api.source.network

import co.za.softwareological.kaylen.core_api.source.connector.SourceNetworkConnector
import co.za.softwareological.kaylen.feature_agent.api.model.response.DTOResponseAgentList
import co.za.softwareological.kaylen.feature_agent.api.source.network.config.SourceNetworkAgentConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

internal interface SourceNetworkAgent : SourceNetworkConnector {

    @GET(SourceNetworkAgentConfig.AGENTS)
    suspend fun getAgentList(
        @QueryMap queryParams: Map<String, String>
    ) : Response<DTOResponseAgentList>

}