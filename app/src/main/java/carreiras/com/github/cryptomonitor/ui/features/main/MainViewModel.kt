
package carreiras.com.github.cryptomonitor.ui.features.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import carreiras.com.github.cryptomonitor.service.MercadoBitcoinServiceFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class TickerUiState(
    val value: String = "",
    val date: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

class MainViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(TickerUiState())
    val uiState: StateFlow<TickerUiState> = _uiState

    init {
        fetchTicker()
    }

    fun fetchTicker() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)
            try {
                val service = MercadoBitcoinServiceFactory().create()
                val response = service.getTicker()

                if (response.isSuccessful) {
                    val tickerResponse = response.body()

                    val lastValue = tickerResponse?.ticker?.last?.toDoubleOrNull()
                    val formattedValue = if (lastValue != null) {
                        val numberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
                        numberFormat.format(lastValue)
                    } else {
                        ""
                    }

                    val date = tickerResponse?.ticker?.date?.let { Date(it * 1000L) }
                    val formattedDate = if (date != null) {
                        val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
                        sdf.format(date)
                    } else {
                        ""
                    }

                    _uiState.value = _uiState.value.copy(
                        value = formattedValue,
                        date = formattedDate,
                        isLoading = false
                    )
                } else {
                    val errorMessage = when (response.code()) {
                        400 -> "Requisição inválida"
                        401 -> "Não autorizado"
                        403 -> "Acesso negado"
                        404 -> "Não encontrado"
                        else -> "Erro desconhecido"
                    }
                    _uiState.value = _uiState.value.copy(errorMessage = errorMessage, isLoading = false)
                }

            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    errorMessage = "Falha na conexão. Verifique sua internet.",
                    isLoading = false
                )
            }
        }
    }
}
