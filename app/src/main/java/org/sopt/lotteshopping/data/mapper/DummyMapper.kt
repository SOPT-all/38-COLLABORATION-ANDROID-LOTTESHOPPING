package org.sopt.lotteshopping.data.mapper

import org.sopt.lotteshopping.data.model.Dummy
import org.sopt.lotteshopping.data.remote.dto.DummyResponseDto

fun DummyResponseDto.toModel() =
    Dummy(
        dummy = dummy,
    )
