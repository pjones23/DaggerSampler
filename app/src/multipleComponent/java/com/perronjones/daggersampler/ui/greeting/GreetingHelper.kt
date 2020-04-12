package com.perronjones.daggersampler.ui.greeting

import com.perronjones.daggersampler.DaggerSamplerApp

class GreetingHelper(private val appContext: DaggerSamplerApp) {
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

    fun injectDependencies(greetingFragment: GreetingFragment) {
        appContext.getGreetingComponent()?.inject(greetingFragment)
    }

    fun injectDependencies(frenchGreetingFragment: FrenchGreetingFragment) {
        appContext.getGreetingComponent()?.inject(frenchGreetingFragment)
    }

    fun injectDependencies(spanishGreetingFragment: SpanishGreetingFragment) {
        appContext.getGreetingComponent()?.inject(spanishGreetingFragment)
    }
}