package com.perronjones.daggersampler.di.greeting

import com.perronjones.daggersampler.di.*
import com.perronjones.daggersampler.info.InfoProvider
import com.perronjones.daggersampler.info.greeting.FrenchGreetingInfoProvider
import com.perronjones.daggersampler.info.greeting.GreetingDefinitionInfoProvider
import com.perronjones.daggersampler.info.greeting.SpanishGreetingInfoProvider
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class GreetingModule {
    @Singleton
    @Provides
    @Named(DEFINITION)
    fun provideGreetingDefinition(): GreetingDefinitionInfoProvider = GreetingDefinitionInfoProvider()

    @Provides
    @Named(FRENCH)
    fun provideFrenchGreetingMessage() : FrenchGreetingInfoProvider = FrenchGreetingInfoProvider()

    @Provides
    @Named(SPANISH)
    fun provideSpanishGreetingMessage() : SpanishGreetingInfoProvider = SpanishGreetingInfoProvider()
}