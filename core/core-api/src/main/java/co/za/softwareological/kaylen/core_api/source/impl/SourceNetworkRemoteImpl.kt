package co.za.softwareological.kaylen.core_api.source.impl

import co.za.softwareological.kaylen.core_api.source.SourceNetwork
import co.za.softwareological.kaylen.core_api.source.connector.SourceNetworkConnector
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class SourceNetworkRemoteImpl : SourceNetwork {

    override fun <E: SourceNetworkConnector> generateConnector(clazz: Class<E>): E? {
        return retrofitImpl.create(clazz)
    }

    companion object {
        private const val BASE_URL = "https://valorant-api.com/v1/"
        private val retrofitImpl: Retrofit = createRetrofitImpl()

        private fun createRetrofitImpl(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}