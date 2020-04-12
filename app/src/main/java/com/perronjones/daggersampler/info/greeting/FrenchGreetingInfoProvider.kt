package com.perronjones.daggersampler.info.greeting

import com.perronjones.daggersampler.info.InfoProvider

class FrenchGreetingInfoProvider : InfoProvider {
    override fun provideInfo(): String = "Bonjour"
}