package com.perronjones.daggersampler.di.greeting

import com.perronjones.daggersampler.di.DEFINITION
import com.perronjones.daggersampler.di.FRENCH
import com.perronjones.daggersampler.di.GreetingScope
import com.perronjones.daggersampler.di.SPANISH
import com.perronjones.daggersampler.info.InfoProvider
import com.perronjones.daggersampler.info.greeting.FrenchGreetingInfoProvider
import com.perronjones.daggersampler.info.greeting.GreetingDefinitionInfoProvider
import com.perronjones.daggersampler.info.greeting.SpanishGreetingInfoProvider
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class GreetingModule {
    @GreetingScope
    @Provides
    @Named(DEFINITION)
    fun provideGreetingDefinition(): InfoProvider = GreetingDefinitionInfoProvider()

    @Provides
    @Named(FRENCH)
    fun provideFrenchGreetingMessage() : InfoProvider = FrenchGreetingInfoProvider()

    @Provides
    @Named(SPANISH)
    fun provideSpanishGreetingMessage() : InfoProvider = SpanishGreetingInfoProvider()
}