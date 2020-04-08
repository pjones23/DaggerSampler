package com.perronjones.daggersampler.di.greeting

import com.perronjones.daggersampler.di.DEFINITION
import com.perronjones.daggersampler.di.FRENCH
import com.perronjones.daggersampler.di.GreetingScope
import com.perronjones.daggersampler.di.SPANISH
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class GreetingModule {
    @GreetingScope
    @Provides
    @Named(DEFINITION)
    fun provideGreetingDefinition(): String = "Greeting Definition"

    @Provides
    @Named(FRENCH)
    fun provideFrenchGreetingMessage() : String = "Bonjour"

    @Provides
    @Named(SPANISH)
    fun provideSpanishGreetingMessage() : String = "Hola"
}