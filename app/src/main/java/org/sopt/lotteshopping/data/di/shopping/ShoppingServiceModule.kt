package org.sopt.lotteshopping.data.di.shopping

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.lotteshopping.data.remote.service.ShoppingService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ShoppingServiceModule {
    @Provides
    @Singleton
    fun providesShoppingService(retrofit: Retrofit): ShoppingService =
        retrofit.create(ShoppingService::class.java)
}
