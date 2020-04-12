package com.perronjones.daggersampler.di.farewell

import com.perronjones.daggersampler.di.*
import com.perronjones.daggersampler.info.InfoProvider
import com.perronjones.daggersampler.info.farewell.FrenchFarewellInfoProvider
import com.perronjones.daggersampler.info.farewell.SpanishFarewellInfoProvider
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class BaseFarewellModule {
    @Provides
    @Named(FRENCH)
    fun provideFrenchFarewellMessage() : InfoProvider = FrenchFarewellInfoProvider()

    @Provides
    @Named(SPANISH)
    fun provideSpanishFarewellMessage() : InfoProvider = SpanishFarewellInfoProvider()
}