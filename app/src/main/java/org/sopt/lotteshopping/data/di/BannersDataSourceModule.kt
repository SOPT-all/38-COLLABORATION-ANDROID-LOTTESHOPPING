package org.sopt.lotteshopping.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.lotteshopping.data.remote.datasource.BannersRemoteDataSource
import org.sopt.lotteshopping.data.remote.datasourceImpl.BannersRemoteDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BannersDataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsBannersDataSource(
        bannersDataSourceImpl: BannersRemoteDataSourceImpl,
    ): BannersRemoteDataSource
}
