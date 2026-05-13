package org.sopt.lotteshopping.data

import java.time.LocalDate

data class HomePreferenceModel (

    val id : Long,
    val title: String,
    val targetBranch : String,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val imageUrl : String

    )

