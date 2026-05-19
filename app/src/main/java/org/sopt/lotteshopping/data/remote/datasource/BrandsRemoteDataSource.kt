package org.sopt.lotteshopping.data.remote.datasource

import org.sopt.lotteshopping.data.remote.dto.BaseResponse
import org.sopt.lotteshopping.data.remote.dto.brands.GetHomeBrandsResponse

interface BrandsRemoteDataSource {
    suspend fun getHomeBrands(): BaseResponse<List<GetHomeBrandsResponse>>
}
