package co.za.softwareological.kaylen.valorantcompanion.approot

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import co.za.softwareological.kaylen.feature_agent.presentation.viewmodel.ViewModelAgentList
import co.za.softwareological.kaylen.feature_agent.presentation.viewmodel.factory.ViewModelFactoryAgentList
import co.za.softwareological.kaylen.valorantcompanion.databinding.AppRootLayoutBinding

class ViewAppRootImpl : AppCompatActivity() {

    private lateinit var binding: AppRootLayoutBinding
    private val viewModel: ViewModelAgentList by viewModels { ViewModelFactoryAgentList() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = AppRootLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeUiState()
    }

    private fun observeUiState() {
        lifecycleScope.launchWhenResumed {
            viewModel.uiState.collect { state ->
                binding.appRootTestData.text = state.testData
            }
        }
    }

}