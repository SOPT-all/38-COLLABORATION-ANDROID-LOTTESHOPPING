package org.sopt.lotteshopping.data.di.shopping

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.lotteshopping.data.repository.ShoppingRepository
import org.sopt.lotteshopping.data.repositoryImpl.ShoppingRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ShoppingRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsShoppingRepository(
        shoppingRepositoryImpl: ShoppingRepositoryImpl,
    ): ShoppingRepository
}
