
package carreiras.com.github.cryptomonitor.ui.features.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import carreiras.com.github.cryptomonitor.ui.composables.QuoteInformation

@Composable
fun MainScreen(uiState: TickerUiState, onRefresh: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        MainToolbar()
        QuoteInformation(uiState = uiState, onRefresh = onRefresh)
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(TickerUiState(value = "R$ 1.234,56", date = "01/01/2023 12:00:00"), onRefresh = {})
}
