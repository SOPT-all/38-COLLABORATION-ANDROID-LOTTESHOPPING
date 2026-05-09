package org.sopt.lotteshopping.data.remote.datasourceImpl

import org.sopt.lotteshopping.data.remote.datasource.DummyDataSource
import org.sopt.lotteshopping.data.remote.dto.DummyResponseDto
import org.sopt.lotteshopping.data.remote.service.DummyService
import javax.inject.Inject

class DummyDataSourceImpl @Inject constructor(
    private val service: DummyService,
) : DummyDataSource {
    override suspend fun getDummy(): DummyResponseDto = service.getDummy()
}
