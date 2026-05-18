package org.sopt.lotteshopping.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.lotteshopping.data.remote.service.BannersService
import retrofit2.Retrofit
import javax.inject.Singleton
import kotlin.jvm.java

@Module
@InstallIn(SingletonComponent::class)
object BannersServiceModule {
    @Provides
    @Singleton
    fun providesBannersService(retrofit: Retrofit): BannersService =
        retrofit.create(BannersService::class.java)
}
