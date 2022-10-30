package co.za.softwareological.kaylen.valorantcompanion.approot

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import co.za.softwareological.kaylen.feature_agent.presentation.viewmodel.ViewModelAgentList
import co.za.softwareological.kaylen.feature_agent.presentation.viewmodel.factory.ViewModelFactoryAgentList

class ViewAppRootImpl : AppCompatActivity() {

    private val viewModel: ViewModelAgentList by viewModels { ViewModelFactoryAgentList() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.onInit()
    }

}