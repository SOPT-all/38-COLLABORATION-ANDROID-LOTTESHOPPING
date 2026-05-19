package org.sopt.lotteshopping.data.remote.datasourceImpl

import org.sopt.lotteshopping.data.remote.datasource.BrandsRemoteDataSource
import org.sopt.lotteshopping.data.remote.dto.BaseResponse
import org.sopt.lotteshopping.data.remote.dto.brands.GetHomeBrandsResponse
import org.sopt.lotteshopping.data.remote.service.BrandsService
import javax.inject.Inject

class BrandsRemoteDataSourceImpl @Inject constructor(
    private val brandsService: BrandsService
) : BrandsRemoteDataSource {
    override suspend fun getHomeBrands(): BaseResponse<List<GetHomeBrandsResponse>> =
        brandsService.getHomeBrands()
}
