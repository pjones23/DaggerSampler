package com.perronjones.daggersampler.di.farewell

import com.perronjones.daggersampler.di.FarewellScope
import com.perronjones.daggersampler.info.farewell.FarewellDefinitionInfoProvider
import dagger.Module
import dagger.Provides

@Module(includes = [BaseFarewellModule::class])
class FarewellModule {
    @FarewellScope
    @Provides
    fun provideFarewellDefinition(): FarewellDefinitionInfoProvider = FarewellDefinitionInfoProvider()
}