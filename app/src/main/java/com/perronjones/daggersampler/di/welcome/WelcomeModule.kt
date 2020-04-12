package com.perronjones.daggersampler.di.welcome

import com.perronjones.daggersampler.di.DEFINITION
import com.perronjones.daggersampler.di.FAREWELL
import com.perronjones.daggersampler.di.GREETING
import com.perronjones.daggersampler.info.InfoProvider
import com.perronjones.daggersampler.info.welcome.FarewellWelcomeTitleInfoProvider
import com.perronjones.daggersampler.info.welcome.GreetingWelcomeTitleInfoProvider
import com.perronjones.daggersampler.info.welcome.WelcomeDefinitionInfoProvider
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class WelcomeModule {
    @Provides
    @Named(DEFINITION)
    fun provideWelcomeDefinition(): InfoProvider = WelcomeDefinitionInfoProvider()

    @Provides
    @Named(FAREWELL)
    fun providesFarewellTitle(): InfoProvider = FarewellWelcomeTitleInfoProvider()

    @Provides
    @Named(GREETING)
    fun providesGreetingTitle(): InfoProvider = GreetingWelcomeTitleInfoProvider()
}