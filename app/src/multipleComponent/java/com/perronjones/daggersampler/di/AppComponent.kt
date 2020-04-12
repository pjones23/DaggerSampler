package com.perronjones.daggersampler.di

import com.perronjones.daggersampler.info.InfoProvider
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    @Named(APP)
    fun getAppProviderInfo(): InfoProvider
}