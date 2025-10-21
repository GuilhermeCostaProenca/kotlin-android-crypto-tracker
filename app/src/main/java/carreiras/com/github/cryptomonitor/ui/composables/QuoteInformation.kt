
package carreiras.com.github.cryptomonitor.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import carreiras.com.github.cryptomonitor.R
import carreiras.com.github.cryptomonitor.ui.features.main.TickerUiState

@Composable
fun QuoteInformation(uiState: TickerUiState, onRefresh: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (uiState.isLoading) {
            CircularProgressIndicator()
        } else {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (uiState.errorMessage != null) {
                    Text(
                        text = uiState.errorMessage,
                        color = Color.Red,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp)
                    )
                } else {
                    Text(
                        text = stringResource(id = R.string.label_rate),
                        fontSize = 20.sp
                    )
                    Text(
                        text = uiState.value,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = uiState.date
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                RefreshButton(onClick = onRefresh)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuoteInformationPreviewLoading() {
    QuoteInformation(TickerUiState(isLoading = true), onRefresh = {})
}

@Preview(showBackground = true)
@Composable
fun QuoteInformationPreviewError() {
    QuoteInformation(TickerUiState(errorMessage = "Falha na conexão."), onRefresh = {})
}

@Preview(showBackground = true)
@Composable
fun QuoteInformationPreviewSuccess() {
    QuoteInformation(TickerUiState(value = "R$ 23.456,78", date = "20/05/2024 10:30:00"), onRefresh = {})
}
