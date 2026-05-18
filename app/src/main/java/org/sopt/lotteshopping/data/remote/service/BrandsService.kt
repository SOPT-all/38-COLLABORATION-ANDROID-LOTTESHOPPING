package org.sopt.lotteshopping.data.remote.service

import org.sopt.lotteshopping.data.remote.dto.BaseResponse
import org.sopt.lotteshopping.data.remote.dto.brands.GetHomeBrandsResponse
import retrofit2.http.GET

interface BrandsService {
    @GET("api/v1/brands")
    suspend fun getHomeBrands(): BaseResponse<List<GetHomeBrandsResponse>>
}
