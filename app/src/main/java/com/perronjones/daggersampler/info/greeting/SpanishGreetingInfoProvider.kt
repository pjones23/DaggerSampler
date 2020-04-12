package com.perronjones.daggersampler.info.greeting

import com.perronjones.daggersampler.info.InfoProvider

class SpanishGreetingInfoProvider : InfoProvider {
    override fun provideInfo(): String = "Hola"
}