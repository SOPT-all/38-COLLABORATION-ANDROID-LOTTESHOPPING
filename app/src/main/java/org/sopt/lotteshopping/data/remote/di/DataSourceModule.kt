package org.sopt.lotteshopping.data.remote.di

import org.sopt.lotteshopping.data.remote.datasource.DummyDataSource
import org.sopt.lotteshopping.data.remote.datasourceImpl.DummyDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsDummyDataSource(
        dataSourceImpl: DummyDataSourceImpl,
    ): DummyDataSource
}
