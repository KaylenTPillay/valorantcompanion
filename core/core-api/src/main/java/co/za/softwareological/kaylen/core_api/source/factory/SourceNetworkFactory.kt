package co.za.softwareological.kaylen.core_api.source.factory

import co.za.softwareological.kaylen.core_api.source.SourceNetwork
import co.za.softwareological.kaylen.core_api.source.connector.SourceNetworkConnector
import co.za.softwareological.kaylen.core_api.source.impl.SourceNetworkRemoteImpl

object SourceNetworkFactory : SourceNetwork {

    private val sourceNetworkImpl: SourceNetwork = initialiseSourceNetworkImpl()

    override fun <E: SourceNetworkConnector> generateConnector(clazz: Class<E>): E? {
        return sourceNetworkImpl.generateConnector(clazz)
    }

    private fun initialiseSourceNetworkImpl(): SourceNetwork {
        return SourceNetworkRemoteImpl()
    }

}