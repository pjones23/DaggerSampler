package com.perronjones.daggersampler.di.greeting

import com.perronjones.daggersampler.info.greeting.GreetingDefinitionInfoProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [BaseGreetingModule::class])
class GreetingModule {
    @Singleton
    @Provides
    fun provideGreetingDefinition(): GreetingDefinitionInfoProvider = GreetingDefinitionInfoProvider()
}