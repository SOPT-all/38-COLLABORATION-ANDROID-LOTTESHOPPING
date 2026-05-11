package org.sopt.lotteshopping.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
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
            letterSpacing = LETTER_SPACING_LARGE,
        ),
    ),
    title = LotteTitleTypography(
        sb18 = lotteTextStyle(
            weight = FontWeight.SemiBold,
            size = 18,
            letterSpacing = LETTER_SPACING_LARGE,
        ),
        m18 = lotteTextStyle(
            weight = FontWeight.Medium,
            size = 18,
            letterSpacing = LETTER_SPACING_LARGE,
        ),
        r18 = lotteTextStyle(
            weight = FontWeight.Normal,
            size = 18,
            letterSpacing = LETTER_SPACING_LARGE,
        ),
    ),
    body = LotteBodyTypography(
        sb16 = lotteTextStyle(
            weight = FontWeight.SemiBold,
            size = 16,
            letterSpacing = LETTER_SPACING_SMALL,
        ),
        m16 = lotteTextStyle(
            weight = FontWeight.Medium,
            size = 16,
            letterSpacing = LETTER_SPACING_SMALL,
        ),
        r16 = lotteTextStyle(
            weight = FontWeight.Normal,
            size = 16,
            letterSpacing = LETTER_SPACING_SMALL,
        ),
        sb14 = lotteTextStyle(
            weight = FontWeight.SemiBold,
            size = 14,
            letterSpacing = LETTER_SPACING_SMALL,
        ),
        m14 = lotteTextStyle(
            weight = FontWeight.Medium,
            size = 14,
            letterSpacing = LETTER_SPACING_SMALL,
        ),
        r14 = lotteTextStyle(
            weight = FontWeight.Normal,
            size = 14,
            letterSpacing = LETTER_SPACING_SMALL,
        ),
    ),
    label = LotteLabelTypography(
        m12 = lotteTextStyle(
            weight = FontWeight.Medium,
            size = 12,
            letterSpacing = LETTER_SPACING_SMALL,
        ),
        r12 = lotteTextStyle(
            weight = FontWeight.Normal,
            size = 12,
            letterSpacing = LETTER_SPACING_SMALL,
        ),
    ),
    caption = LotteCaptionTypography(
        r10 = lotteTextStyle(
            weight = FontWeight.Normal,
            size = 10,
            letterSpacing = LETTER_SPACING_SMALL,
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
    letterSpacing: Float,
) = TextStyle(
    fontFamily = NotoSansKr,
    fontWeight = weight,
    fontSize = size.sp,
    lineHeight = DEFAULT_LINE_HEIGHT.em,
    letterSpacing = letterSpacing.em,
    platformStyle = PlatformTextStyle(
        includeFontPadding = false,
    ),
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.None,
    ),
)

private const val DEFAULT_LINE_HEIGHT = 1.4f
private const val LETTER_SPACING_LARGE = -0.01f
private const val LETTER_SPACING_SMALL = -0.02f
