package org.sopt.lotteshopping.data.di.brands

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.lotteshopping.data.remote.service.BrandsService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BrandsServiceModule {
    @Provides
    @Singleton
    fun providesBrandsService(retrofit: Retrofit): BrandsService =
        retrofit.create(BrandsService::class.java)
}
