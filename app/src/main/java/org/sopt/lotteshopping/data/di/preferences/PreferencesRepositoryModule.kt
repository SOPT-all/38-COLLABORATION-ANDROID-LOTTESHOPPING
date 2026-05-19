package org.sopt.lotteshopping.data.di.preferences

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.lotteshopping.data.repository.PreferenceRepository
import org.sopt.lotteshopping.data.repositoryImpl.PreferenceRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PreferencesRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsPreferenceRepository(
        preferenceRepositoryImpl: PreferenceRepositoryImpl,
    ): PreferenceRepository
}
