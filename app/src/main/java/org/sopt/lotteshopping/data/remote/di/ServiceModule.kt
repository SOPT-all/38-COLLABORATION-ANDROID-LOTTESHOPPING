package org.sopt.lotteshopping.data.remote.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.lotteshopping.data.remote.service.DummyService
import org.sopt.lotteshopping.data.remote.service.PreferenceService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun providesDummyService(retrofit: Retrofit): DummyService = retrofit.create(DummyService::class.java)

    @Provides
    @Singleton
    fun providesPreferenceService(retrofit: Retrofit): PreferenceService = retrofit.create(PreferenceService::class.java)
}
