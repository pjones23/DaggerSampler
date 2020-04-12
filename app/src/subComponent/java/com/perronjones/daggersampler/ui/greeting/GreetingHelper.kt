package com.perronjones.daggersampler.ui.greeting

import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.di.ComponentProvider
import com.perronjones.daggersampler.di.greeting.GreetingComponent

class GreetingHelper {
    fun setComponent(appContext: DaggerSamplerApp) {
        val greetingComponent = appContext.appComponent.getGreetingComponentFactory().create()
        appContext.setGreetingComponent(object : ComponentProvider<GreetingComponent> {
            override fun provideComponent(): GreetingComponent? = greetingComponent
        })
    }

    fun unsetComponent(appContext: DaggerSamplerApp) {
        appContext.setGreetingComponent(null)
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