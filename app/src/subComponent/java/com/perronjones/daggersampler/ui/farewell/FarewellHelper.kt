package com.perronjones.daggersampler.ui.farewell

import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.di.ComponentProvider
import com.perronjones.daggersampler.di.farewell.FarewellComponent

class FarewellHelper {

    fun setComponent(appContext: DaggerSamplerApp) {
        val farewellComponent = appContext.appComponent.getFarewellComponentFactory().create()
        appContext.setFarewellComponent(object : ComponentProvider<FarewellComponent> {
            override fun provideComponent(): FarewellComponent? = farewellComponent
        })
    }

    fun unsetComponent(appContext: DaggerSamplerApp) {
        appContext.setFarewellComponent(null)
    }

    fun injectDependencies(appContext: DaggerSamplerApp, farewellFragment: FarewellFragment) {
        appContext.getFarewellComponent()?.inject(farewellFragment)
    }

    fun injectDependencies(appContext: DaggerSamplerApp, frenchFarewellFragment: FrenchFarewellFragment) {
        appContext.getFarewellComponent()?.inject(frenchFarewellFragment)
    }

    fun injectDependencies(appContext: DaggerSamplerApp, spanishFarewellFragment: SpanishFarewellFragment) {
        appContext.getFarewellComponent()?.inject(spanishFarewellFragment)
    }
}