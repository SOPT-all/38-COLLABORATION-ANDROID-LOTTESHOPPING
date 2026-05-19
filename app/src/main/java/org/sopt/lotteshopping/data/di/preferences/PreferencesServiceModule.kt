package org.sopt.lotteshopping.data.di.preferences

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.lotteshopping.data.remote.service.PreferenceService
import retrofit2.Retrofit
import javax.inject.Singleton

// #[FEAT/#31]
@Module
@InstallIn(SingletonComponent::class)
object PreferencesServiceModule {
    @Provides
    @Singleton
    fun providesPreferenceService(retrofit: Retrofit): PreferenceService =
        retrofit.create(PreferenceService::class.java)
}
