package com.perronjones.daggersampler.di.welcome

import com.perronjones.daggersampler.info.welcome.FarewellWelcomeTitleInfoProvider
import com.perronjones.daggersampler.info.welcome.GreetingWelcomeTitleInfoProvider
import com.perronjones.daggersampler.info.welcome.WelcomeDefinitionInfoProvider
import dagger.Module
import dagger.Provides

@Module
class WelcomeModule {
    @Provides
    fun provideWelcomeDefinition(): WelcomeDefinitionInfoProvider = WelcomeDefinitionInfoProvider()

    @Provides
    fun providesFarewellTitle(): FarewellWelcomeTitleInfoProvider = FarewellWelcomeTitleInfoProvider()

    @Provides
    fun providesGreetingTitle(): GreetingWelcomeTitleInfoProvider = GreetingWelcomeTitleInfoProvider()
}