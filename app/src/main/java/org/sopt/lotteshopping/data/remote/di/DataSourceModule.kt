package org.sopt.lotteshopping.data.remote.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.lotteshopping.data.remote.datasource.BannersDataSource
import org.sopt.lotteshopping.data.remote.datasourceImpl.BannersDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsBannersDataSource(
        bannersDataSourceImpl: BannersDataSourceImpl,
    ): BannersDataSource
}
