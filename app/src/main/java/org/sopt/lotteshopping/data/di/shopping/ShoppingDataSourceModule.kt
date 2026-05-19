package org.sopt.lotteshopping.data.di.shopping

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.lotteshopping.data.remote.datasource.ShoppingDataSource
import org.sopt.lotteshopping.data.remote.datasourceImpl.ShoppingDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ShoppingDataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsShoppingDataSource(
        shoppingDataSourceImpl: ShoppingDataSourceImpl,
    ): ShoppingDataSource
}
