package com.perronjones.daggersampler.di.farewell

import com.perronjones.daggersampler.info.farewell.FarewellDefinitionInfoProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [BaseFarewellModule::class])
class FarewellModule {
    @Singleton
    @Provides
    fun provideFarewellDefinition(): FarewellDefinitionInfoProvider = FarewellDefinitionInfoProvider()
}