package co.za.softwareological.kaylen.valorantcompanion.approot

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import co.za.softwareological.kaylen.feature_agent.presentation.view.ViewAgentList
import org.koin.android.ext.android.inject

class ViewAppRootImpl : AppCompatActivity() {

    private val viewAgentList: ViewAgentList by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            viewAgentList.RenderScreen()
        }

    }

}