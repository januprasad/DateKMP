package ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import font

@Composable
fun getTypography(): androidx.compose.material3.Typography {
    val Extensa = FontFamily(
        font(
            name = "Extensa",
            res = "extensa",
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        ),
    )
    val HelveticaFamily =
        FontFamily(
            font(
                name = "Helvetica",
                res = "helvetica_rounded",
                weight = FontWeight.Normal,
                style = FontStyle.Normal
            ),
        )

    return androidx.compose.material3.Typography(
        displayLarge = TextStyle(
            fontFamily = Extensa,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
        ),
        displayMedium = TextStyle(
            fontFamily = Extensa,
            fontSize = 25.sp,
            fontWeight = FontWeight.Normal,
        ),
        titleLarge = TextStyle(
            fontFamily = HelveticaFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 22.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.sp,
        ),
    )
}