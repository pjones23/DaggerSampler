package com.perronjones.daggersampler.info

import javax.inject.Singleton

@Singleton
class AppInfoProvider: InfoProvider {
    override fun provideInfo(): String = "This is just a sample. Version 1"
}