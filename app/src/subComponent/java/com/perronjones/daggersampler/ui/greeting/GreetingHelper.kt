package com.perronjones.daggersampler.ui.greeting

import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.di.ComponentProvider
import com.perronjones.daggersampler.di.greeting.GreetingComponent

class GreetingHelper(private val appContext: DaggerSamplerApp) {
    fun setComponent() {
        val greetingComponent = appContext.appComponent.getGreetingComponentFactory().create()
        appContext.setGreetingComponent(object : ComponentProvider<GreetingComponent> {
            override fun provideComponent(): GreetingComponent? = greetingComponent
        })
    }

    fun unsetComponent() {
        appContext.setGreetingComponent(null)
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