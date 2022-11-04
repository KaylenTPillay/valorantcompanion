package co.za.softwareological.kaylen.valorantcompanion.appstartup.koin

import android.content.Context
import androidx.startup.Initializer
import co.za.softwareological.kaylen.feature_agent.di.featureAgentDIModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.module

@Suppress("unused")
class KoinDIInitializer : Initializer<KoinApplication> {

    override fun create(context: Context): KoinApplication {
        val applicationModules = module {
            includes(featureAgentDIModule)
        }
        return startKoin {
            androidLogger()
            androidContext(context)

            modules(applicationModules)
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()

}