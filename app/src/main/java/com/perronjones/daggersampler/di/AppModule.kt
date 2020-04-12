package com.perronjones.daggersampler.di

import com.perronjones.daggersampler.info.AppInfoProvider
import com.perronjones.daggersampler.info.InfoProvider
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    @Named(APP)
    fun providesAppSampleMessage() : InfoProvider = AppInfoProvider()
}