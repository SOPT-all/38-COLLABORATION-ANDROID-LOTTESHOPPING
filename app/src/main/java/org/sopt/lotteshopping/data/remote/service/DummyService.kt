package org.sopt.lotteshopping.data.remote.service

import org.sopt.lotteshopping.data.remote.dto.DummyResponseDto
import retrofit2.http.GET

interface DummyService {
    @GET("/api/v1/dummy")
    suspend fun getDummy(): DummyResponseDto
}

