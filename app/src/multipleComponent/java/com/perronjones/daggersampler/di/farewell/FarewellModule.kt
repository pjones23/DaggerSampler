package com.perronjones.daggersampler.di.farewell

import com.perronjones.daggersampler.di.DEFINITION
import com.perronjones.daggersampler.di.FarewellScope
import com.perronjones.daggersampler.info.InfoProvider
import com.perronjones.daggersampler.info.farewell.FarewellDefinitionInfoProvider
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [BaseFarewellModule::class])
class FarewellModule {
    @FarewellScope
    @Provides
    @Named(DEFINITION)
    fun provideFarewellDefinition(): InfoProvider = FarewellDefinitionInfoProvider()
}