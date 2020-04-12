package com.perronjones.daggersampler.info.farewell

import com.perronjones.daggersampler.di.FarewellScope
import com.perronjones.daggersampler.info.InfoProvider

@FarewellScope
class FarewellDefinitionInfoProvider : InfoProvider {
    override fun provideInfo(): String = "Farewell Definition"
}