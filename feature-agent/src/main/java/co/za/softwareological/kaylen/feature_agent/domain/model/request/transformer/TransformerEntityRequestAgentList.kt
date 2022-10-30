package co.za.softwareological.kaylen.feature_agent.domain.model.request.transformer

import co.za.softwareological.kaylen.feature_agent.api.model.request.DTORequestAgentList
import co.za.softwareological.kaylen.feature_agent.domain.model.request.EntityRequestAgentList

internal object TransformerEntityRequestAgentList {

    fun EntityRequestAgentList.toDTORequestAgentList(): DTORequestAgentList {
        return DTORequestAgentList(
            language = lang,
            isPlayableCharacter = isPlayableCharacter
        )
    }

}