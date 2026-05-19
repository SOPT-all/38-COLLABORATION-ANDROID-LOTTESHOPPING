package org.sopt.lotteshopping.data.di.preferences

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.lotteshopping.data.remote.datasource.PreferenceRemoteDataSource
import org.sopt.lotteshopping.data.remote.datasourceImpl.PreferenceRemoteDataSourceImpl
import javax.inject.Singleton

// #[FEAT/#31]
@Module
@InstallIn(SingletonComponent::class)
abstract class PreferencesDataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsPreferenceRemoteDataSource(
        preferenceRemoteDataSourceImpl: PreferenceRemoteDataSourceImpl,
    ): PreferenceRemoteDataSource
}
