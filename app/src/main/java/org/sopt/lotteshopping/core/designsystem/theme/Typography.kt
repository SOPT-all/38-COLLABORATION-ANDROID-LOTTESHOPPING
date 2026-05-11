package org.sopt.lotteshopping.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.sopt.lotteshopping.R

private val NotoSansKr = FontFamily(
    Font(R.font.noto_sans_kr_regular, FontWeight.Normal),
    Font(R.font.noto_sans_kr_medium, FontWeight.Medium),
    Font(R.font.noto_sans_kr_semibold, FontWeight.SemiBold),
    Font(R.font.noto_sans_kr_bold, FontWeight.Bold),
)

@Immutable
data class LotteTypography(
    val display: LotteDisplayTypography,
    val title: LotteTitleTypography,
    val body: LotteBodyTypography,
    val label: LotteLabelTypography,
    val caption: LotteCaptionTypography,
)

@Immutable
data class LotteDisplayTypography(
    val b30: TextStyle,
)

@Immutable
data class LotteTitleTypography(
    val sb18: TextStyle,
    val m18: TextStyle,
    val r18: TextStyle,
)

@Immutable
data class LotteBodyTypography(
    val sb16: TextStyle,
    val m16: TextStyle,
    val r16: TextStyle,
    val sb14: TextStyle,
    val m14: TextStyle,
    val r14: TextStyle,
)

@Immutable
data class LotteLabelTypography(
    val m12: TextStyle,
    val r12: TextStyle,
)

@Immutable
data class LotteCaptionTypography(
    val r10: TextStyle,
)

val defaultLotteTypography = LotteTypography(
    display = LotteDisplayTypography(
        b30 = lotteTextStyle(
            weight = FontWeight.Bold,
            size = 30,
            lineHeight = 42f,
            letterSpacing = -0.3f,
        ),
    ),
    title = LotteTitleTypography(
        sb18 = lotteTextStyle(
            weight = FontWeight.SemiBold,
            size = 18,
            lineHeight = 25.2f,
            letterSpacing = -0.18f,
        ),
        m18 = lotteTextStyle(
            weight = FontWeight.Medium,
            size = 18,
            lineHeight = 25.2f,
            letterSpacing = -0.18f,
        ),
        r18 = lotteTextStyle(
            weight = FontWeight.Normal,
            size = 18,
            lineHeight = 25.2f,
            letterSpacing = -0.18f,
        ),
    ),
    body = LotteBodyTypography(
        sb16 = lotteTextStyle(
            weight = FontWeight.SemiBold,
            size = 16,
            lineHeight = 22.4f,
            letterSpacing = -0.32f,
        ),
        m16 = lotteTextStyle(
            weight = FontWeight.Medium,
            size = 16,
            lineHeight = 22.4f,
            letterSpacing = -0.32f,
        ),
        r16 = lotteTextStyle(
            weight = FontWeight.Normal,
            size = 16,
            lineHeight = 22.4f,
            letterSpacing = -0.32f,
        ),
        sb14 = lotteTextStyle(
            weight = FontWeight.SemiBold,
            size = 14,
            lineHeight = 19.6f,
            letterSpacing = -0.28f,
        ),
        m14 = lotteTextStyle(
            weight = FontWeight.Medium,
            size = 14,
            lineHeight = 19.6f,
            letterSpacing = -0.28f,
        ),
        r14 = lotteTextStyle(
            weight = FontWeight.Normal,
            size = 14,
            lineHeight = 19.6f,
            letterSpacing = -0.28f,
        ),
    ),
    label = LotteLabelTypography(
        m12 = lotteTextStyle(
            weight = FontWeight.Medium,
            size = 12,
            lineHeight = 16.8f,
            letterSpacing = -0.24f,
        ),
        r12 = lotteTextStyle(
            weight = FontWeight.Normal,
            size = 12,
            lineHeight = 16.8f,
            letterSpacing = -0.24f,
        ),
    ),
    caption = LotteCaptionTypography(
        r10 = lotteTextStyle(
            weight = FontWeight.Normal,
            size = 10,
            lineHeight = 14f,
            letterSpacing = -0.2f,
        ),
    ),
)

val defaultMaterialTypography = Typography(
    displayLarge = defaultLotteTypography.display.b30,
    titleLarge = defaultLotteTypography.title.sb18,
    bodyLarge = defaultLotteTypography.body.m16,
    bodyMedium = defaultLotteTypography.body.m14,
    labelMedium = defaultLotteTypography.label.m12,
    labelSmall = defaultLotteTypography.caption.r10,
)

private fun lotteTextStyle(
    weight: FontWeight,
    size: Int,
    lineHeight: Float,
    letterSpacing: Float,
) = TextStyle(
    fontFamily = NotoSansKr,
    fontWeight = weight,
    fontSize = size.sp,
    lineHeight = lineHeight.sp,
    letterSpacing = letterSpacing.sp,
)
