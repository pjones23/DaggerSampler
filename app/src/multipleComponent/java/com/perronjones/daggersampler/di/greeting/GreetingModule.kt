package com.perronjones.daggersampler.di.greeting

import com.perronjones.daggersampler.di.GreetingScope
import com.perronjones.daggersampler.info.greeting.GreetingDefinitionInfoProvider
import dagger.Module
import dagger.Provides

@Module(includes = [BaseGreetingModule::class])
class GreetingModule {
    @GreetingScope
    @Provides
    fun provideGreetingDefinition(): GreetingDefinitionInfoProvider = GreetingDefinitionInfoProvider()
}