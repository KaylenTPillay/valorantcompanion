package co.za.softwareological.kaylen.core_api.source

import co.za.softwareological.kaylen.core_api.source.connector.SourceNetworkConnector

interface SourceNetwork {

    fun <E: SourceNetworkConnector> generateConnector(clazz: Class<E>): E?

}