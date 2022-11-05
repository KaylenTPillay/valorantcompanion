package co.za.softwareological.kaylen.valorantcompanion.approot

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import co.za.softwareological.kaylen.feature_agent.presentation.view.ViewAgentList
import org.koin.android.ext.android.inject

class ViewAppRootImpl : AppCompatActivity() {

    private val viewAgentList: ViewAgentList by inject()

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val widthSizeClass: WindowWidthSizeClass =
                calculateWindowSizeClass(activity = this).widthSizeClass
            val shouldShowDuelPane = widthSizeClass > WindowWidthSizeClass.Compact
            viewAgentList.RenderScreen(shouldShowDuelPane = shouldShowDuelPane)
        }

    }

}