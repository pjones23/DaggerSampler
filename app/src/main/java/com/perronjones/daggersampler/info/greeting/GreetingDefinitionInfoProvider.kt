package com.perronjones.daggersampler.info.greeting

import com.perronjones.daggersampler.info.InfoProvider

class GreetingDefinitionInfoProvider : InfoProvider {
    override fun provideInfo(): String = "Greeting Definition"
}