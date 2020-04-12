package com.perronjones.daggersampler.di.farewell

import com.perronjones.daggersampler.di.*
import com.perronjones.daggersampler.info.InfoProvider
import com.perronjones.daggersampler.info.farewell.FarewellDefinitionInfoProvider
import com.perronjones.daggersampler.info.farewell.FrenchFarewellInfoProvider
import com.perronjones.daggersampler.info.farewell.SpanishFarewellInfoProvider
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class FarewellModule {

    @FarewellScope
    @Provides
    @Named(DEFINITION)
    fun provideFarewellDefinition(): InfoProvider = FarewellDefinitionInfoProvider()

    @Provides
    @Named(FRENCH)
    fun provideFrenchFarewellMessage() : InfoProvider = FrenchFarewellInfoProvider()

    @Provides
    @Named(SPANISH)
    fun provideSpanishFarewellMessage() : InfoProvider = SpanishFarewellInfoProvider()
}