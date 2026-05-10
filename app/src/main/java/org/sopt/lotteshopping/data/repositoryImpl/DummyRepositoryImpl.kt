package org.sopt.lotteshopping.data.repositoryImpl

import org.sopt.lotteshopping.data.mapper.toModel
import org.sopt.lotteshopping.data.model.Dummy
import org.sopt.lotteshopping.data.remote.datasource.DummyDataSource
import org.sopt.lotteshopping.data.repository.DummyRepository
import javax.inject.Inject

class DummyRepositoryImpl @Inject constructor(
    private val dummyDataSource: DummyDataSource,
) : DummyRepository {
    override suspend fun getDummy(): Result<Dummy> =
        runCatching {
            val response = dummyDataSource.getDummy()
            response.toModel()
        }
}
