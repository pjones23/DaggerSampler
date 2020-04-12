package com.perronjones.daggersampler.di.greeting

import com.perronjones.daggersampler.di.DEFINITION
import com.perronjones.daggersampler.di.GreetingScope
import com.perronjones.daggersampler.info.InfoProvider
import com.perronjones.daggersampler.info.greeting.GreetingDefinitionInfoProvider
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [BaseGreetingModule::class])
class GreetingModule {
    @GreetingScope
    @Provides
    @Named(DEFINITION)
    fun provideGreetingDefinition(): InfoProvider = GreetingDefinitionInfoProvider()
}