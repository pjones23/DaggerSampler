package com.perronjones.daggersampler.di

import com.perronjones.daggersampler.info.AppInfoProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun providesAppSampleMessage() : AppInfoProvider = AppInfoProvider()
}