package org.sopt.lotteshopping.core.extension

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
fun String.toFormattedDate(): String =
    runCatching {
        val localDate = LocalDate.parse(this, DateTimeFormatter.ofPattern("yyyy-MM-dd"))

        val monthDay = DateTimeFormatter.ofPattern("M.d").format(localDate)
        val dayOfWeek = DateTimeFormatter.ofPattern("E", Locale.KOREAN).format(localDate)

        return "$monthDay($dayOfWeek)"
    }.getOrDefault(this)
