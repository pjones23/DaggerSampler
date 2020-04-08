package com.perronjones.daggersampler.di.farewell

import com.perronjones.daggersampler.di.*
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class FarewellModule {

    @FarewellScope
    @Provides
    @Named(DEFINITION)
    fun provideFarewellDefinition(): String = "Farewell Definition"

    @Provides
    @Named(FRENCH)
    fun provideFrenchFarewellMessage() : String = "Au revoir"

    @Provides
    @Named(SPANISH)
    fun provideSpanishFarewellMessage() : String = "Adios"
}