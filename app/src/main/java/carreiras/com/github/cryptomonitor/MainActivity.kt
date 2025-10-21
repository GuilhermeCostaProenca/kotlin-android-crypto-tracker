
package carreiras.com.github.cryptomonitor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import carreiras.com.github.cryptomonitor.ui.features.main.MainScreen
import carreiras.com.github.cryptomonitor.ui.features.main.MainViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val uiState by viewModel.uiState.collectAsState()
            MainScreen(uiState = uiState, onRefresh = { viewModel.fetchTicker() })
        }
    }
}
