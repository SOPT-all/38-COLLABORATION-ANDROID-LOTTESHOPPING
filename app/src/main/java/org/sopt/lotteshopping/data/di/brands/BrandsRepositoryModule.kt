package org.sopt.lotteshopping.data.di.brands

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.lotteshopping.data.repository.BrandsRepository
import org.sopt.lotteshopping.data.repositoryImpl.BrandsRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BrandsRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsBrandsRepository(
        brandsRepositoryImpl: BrandsRepositoryImpl
    ): BrandsRepository
}
