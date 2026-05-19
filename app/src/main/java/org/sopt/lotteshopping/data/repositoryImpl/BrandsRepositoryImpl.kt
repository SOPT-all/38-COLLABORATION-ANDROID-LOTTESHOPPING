package org.sopt.lotteshopping.data.repositoryImpl

import org.sopt.lotteshopping.core.util.suspendRunCatching
import org.sopt.lotteshopping.data.mapper.toModel
import org.sopt.lotteshopping.data.model.brands.HomeBeautyBrandModel
import org.sopt.lotteshopping.data.remote.datasource.BrandsRemoteDataSource
import org.sopt.lotteshopping.data.repository.BrandsRepository
import javax.inject.Inject

class BrandsRepositoryImpl @Inject constructor(
    private val brandsRemoteDataSource: BrandsRemoteDataSource
) : BrandsRepository {
    override suspend fun getHomeBrands(): Result<List<HomeBeautyBrandModel>> = suspendRunCatching {
        brandsRemoteDataSource.getHomeBrands().data?.map { it.toModel() } ?: emptyList()
    }
}
