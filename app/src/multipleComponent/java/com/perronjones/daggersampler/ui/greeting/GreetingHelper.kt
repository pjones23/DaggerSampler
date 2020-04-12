package com.perronjones.daggersampler.ui.greeting

import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.di.ComponentProvider
import com.perronjones.daggersampler.di.greeting.DaggerGreetingComponent
import com.perronjones.daggersampler.di.greeting.GreetingComponent

class GreetingHelper {
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

    fun injectDependencies(appContext: DaggerSamplerApp, greetingFragment: GreetingFragment) {
        appContext.getGreetingComponent()?.inject(greetingFragment)
    }

    fun injectDependencies(appContext: DaggerSamplerApp, frenchGreetingFragment: FrenchGreetingFragment) {
        appContext.getGreetingComponent()?.inject(frenchGreetingFragment)
    }

    fun injectDependencies(appContext: DaggerSamplerApp, spanishGreetingFragment: SpanishGreetingFragment) {
        appContext.getGreetingComponent()?.inject(spanishGreetingFragment)
    }
}