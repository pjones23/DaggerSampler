package com.perronjones.daggersampler.di.farewell

import com.perronjones.daggersampler.di.*
import com.perronjones.daggersampler.info.farewell.FarewellDefinitionInfoProvider
import com.perronjones.daggersampler.info.farewell.FrenchFarewellInfoProvider
import com.perronjones.daggersampler.info.farewell.SpanishFarewellInfoProvider
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class FarewellModule {
    @Singleton
    @Provides
    @Named(DEFINITION)
    fun provideFarewellDefinition(): FarewellDefinitionInfoProvider = FarewellDefinitionInfoProvider()

    @Provides
    @Named(FRENCH)
    fun provideFrenchFarewellMessage() : FrenchFarewellInfoProvider = FrenchFarewellInfoProvider()

    @Provides
    @Named(SPANISH)
    fun provideSpanishFarewellMessage() : SpanishFarewellInfoProvider = SpanishFarewellInfoProvider()
}