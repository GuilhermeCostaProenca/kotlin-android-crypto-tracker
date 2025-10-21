
package carreiras.com.github.cryptomonitor.ui.features.main

import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import carreiras.com.github.cryptomonitor.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainToolbar() {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name), color = Color.White) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF0d6efd)
        ),
        modifier = Modifier.height(70.dp)
    )
}

@Preview
@Composable
fun MainToolbarPreview() {
    MainToolbar()
}
