package com.perronjones.daggersampler.di.welcome

import com.perronjones.daggersampler.di.DEFINITION
import com.perronjones.daggersampler.di.FAREWELL
import com.perronjones.daggersampler.di.GREETING
import com.perronjones.daggersampler.di.WelcomeScope
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class WelcomeModule {
    @WelcomeScope
    @Provides
    @Named(DEFINITION)
    fun provideWelcomeDefinition(): String = "Welcome Definition"

    @Provides
    @Named(FAREWELL)
    fun providesFarewellTitle(): String = "Farewell"

    @Provides
    @Named(GREETING)
    fun providesGreetingTitle(): String = "Greeting"
}