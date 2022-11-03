package co.za.softwareological.kaylen.valorantcompanion

import android.app.Application
import co.za.softwareological.kaylen.feature_agent.di.DIFeatureAgent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class ValorantCompanionApplication : Application() {

    private val appModule = module {
        includes(DIFeatureAgent.modules)
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ValorantCompanionApplication)

            modules(appModule)
        }
    }

}