package com.perronjones.daggersampler.ui.farewell

import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.di.ComponentProvider
import com.perronjones.daggersampler.di.farewell.FarewellComponent

class FarewellHelper(private val appContext: DaggerSamplerApp) {

    fun setComponent() {
        val farewellComponent = appContext.appComponent.getFarewellComponentFactory().create()
        appContext.setFarewellComponent(object : ComponentProvider<FarewellComponent> {
            override fun provideComponent(): FarewellComponent? = farewellComponent
        })
    }

    fun unsetComponent() {
        appContext.setFarewellComponent(null)
    }

    fun injectDependencies(farewellFragment: FarewellFragment) {
        appContext.getFarewellComponent()?.inject(farewellFragment)
    }

    fun injectDependencies(frenchFarewellFragment: FrenchFarewellFragment) {
        appContext.getFarewellComponent()?.inject(frenchFarewellFragment)
    }

    fun injectDependencies(spanishFarewellFragment: SpanishFarewellFragment) {
        appContext.getFarewellComponent()?.inject(spanishFarewellFragment)
    }
}