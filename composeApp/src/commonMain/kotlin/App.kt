import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.char
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.theme.AppTheme

data class City(
    val name: String,
    val timezone: TimeZone,
)

@Composable
@Preview
fun TimeSquareScreen() {
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        val cities = listOf(
            City("Berlin", TimeZone.of("Europe/Berlin")),
            City("London", TimeZone.of("Europe/London")),
            City("Tokyo", TimeZone.of("Asia/Tokyo")),
            City("India", TimeZone.of("Asia/Calcutta")),
        )
        var cityTimes by remember {
            mutableStateOf(listOf<Pair<City, LocalDateTime>>())
        }
        LaunchedEffect(true) {
            while (true) {
                cityTimes = cities.map {
                    val now = Clock.System.now()
                    it to now.toLocalDateTime(it.timezone)
                }
                delay(1000L)
            }
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                cityTimes
            ) { (city, dateTime) ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        city.name,
                        style = androidx.compose.material3.MaterialTheme.typography.displayLarge
                    )

                    Column(horizontalAlignment = Alignment.End) {
                        Text(
                            dateTime.format(LocalDateTime.Format {
                                hour()
                                char(':')
                                minute()
                                char(':')
                                second()
                            }),
                            style = androidx.compose.material3.MaterialTheme.typography.displayMedium
                        )

                        Text(
                            city.name,
                            style = androidx.compose.material3.MaterialTheme.typography.displayMedium
                        )
                    }

                }
            }
        }
    }
}