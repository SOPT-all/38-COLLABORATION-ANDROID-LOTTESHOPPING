package org.sopt.lotteshopping.data.di.brands

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.lotteshopping.data.remote.datasource.BrandsRemoteDataSource
import org.sopt.lotteshopping.data.remote.datasourceImpl.BrandsRemoteDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BrandsDataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsBrandsRemoteDataSource(
        brandsRemoteDataSourceImpl: BrandsRemoteDataSourceImpl
    ): BrandsRemoteDataSource
}
