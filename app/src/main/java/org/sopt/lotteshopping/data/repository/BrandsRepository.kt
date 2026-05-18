package org.sopt.lotteshopping.data.repository

import org.sopt.lotteshopping.data.model.brands.HomeBeautyBrandModel

interface BrandsRepository {
    suspend fun getHomeBrands(): Result<List<HomeBeautyBrandModel>>
}
