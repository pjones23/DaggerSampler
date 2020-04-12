package com.perronjones.daggersampler.di

import com.perronjones.daggersampler.info.AppInfoProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun getAppProviderInfo(): AppInfoProvider
}