package com.perronjones.daggersampler.info.greeting

import com.perronjones.daggersampler.info.InfoProvider

open class BaseGreetingDefinitionInfoProvider : InfoProvider {
    override fun provideInfo(): String = "Greeting Definition"
}