package org.sopt.lotteshopping.data.remote.datasource

import org.sopt.lotteshopping.data.remote.dto.DummyResponseDto

interface DummyDataSource {
    suspend fun getDummy(): DummyResponseDto
}
