package co.za.softwareological.kaylen.feature_agent.domain.model

import co.za.softwareological.kaylen.core_util.defaults.UtilDefaults

internal data class EntityAgent(
    val name: String = UtilDefaults.DEFAULT_STRING,
    val description: String = UtilDefaults.DEFAULT_STRING
)