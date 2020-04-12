package com.perronjones.daggersampler.ui.farewell

import com.perronjones.daggersampler.DaggerSamplerApp

class FarewellHelper {

    fun setComponent(appContext: DaggerSamplerApp) {
        /*
         Do Nothing, because it was set during app create in the scenario representing multiple components
         that are created in the Application Context
         */
    }

    fun unsetComponent(appContext: DaggerSamplerApp) {
        /*
        Do Nothing, because it will not be unset in the scenario representing multiple components
        that are created in the Application Context since it is tied to the life cycle of the application
         */
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