package com.perronjones.daggersampler.di.farewell

import com.perronjones.daggersampler.info.farewell.FrenchFarewellInfoProvider
import com.perronjones.daggersampler.info.farewell.SpanishFarewellInfoProvider
import dagger.Module
import dagger.Provides

@Module
class BaseFarewellModule {
    @Provides
    fun provideFrenchFarewellMessage() : FrenchFarewellInfoProvider = FrenchFarewellInfoProvider()

    @Provides
    fun provideSpanishFarewellMessage() : SpanishFarewellInfoProvider = SpanishFarewellInfoProvider()
}