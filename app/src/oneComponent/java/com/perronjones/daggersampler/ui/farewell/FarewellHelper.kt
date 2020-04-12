package com.perronjones.daggersampler.ui.farewell

import com.perronjones.daggersampler.DaggerSamplerApp

class FarewellHelper(private val appContext: DaggerSamplerApp) {

    fun setComponent() {
        /*
         Do Nothing, because it was set during app create in the scenario representing multiple components
         that are created in the Application Context
         */
    }

    fun unsetComponent() {
        /*
        Do Nothing, because it will not be unset in the scenario representing multiple components
        that are created in the Application Context since it is tied to the life cycle of the application
         */
    }

    fun injectDependencies(farewellFragment: FarewellFragment) {
        appContext.appComponent.inject(farewellFragment)
    }

    fun injectDependencies(frenchFarewellFragment: FrenchFarewellFragment) {
        appContext.appComponent.inject(frenchFarewellFragment)
    }

    fun injectDependencies(spanishFarewellFragment: SpanishFarewellFragment) {
        appContext.appComponent.inject(spanishFarewellFragment)
    }
}