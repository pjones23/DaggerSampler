package com.perronjones.daggersampler.di.greeting

import com.perronjones.daggersampler.info.greeting.FrenchGreetingInfoProvider
import com.perronjones.daggersampler.info.greeting.SpanishGreetingInfoProvider
import dagger.Module
import dagger.Provides

@Module
class BaseGreetingModule {
    @Provides
    fun provideFrenchGreetingMessage() : FrenchGreetingInfoProvider = FrenchGreetingInfoProvider()

    @Provides
    fun provideSpanishGreetingMessage() : SpanishGreetingInfoProvider = SpanishGreetingInfoProvider()
}