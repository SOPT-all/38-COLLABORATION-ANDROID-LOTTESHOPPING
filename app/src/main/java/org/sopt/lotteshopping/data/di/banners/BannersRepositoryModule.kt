package org.sopt.lotteshopping.data.di.banners

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.lotteshopping.data.repository.BannersRepository
import org.sopt.lotteshopping.data.repositoryImpl.BannersRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BannersRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsBannersRepository(
        bannersRepositoryImpl: BannersRepositoryImpl,
    ): BannersRepository

}
