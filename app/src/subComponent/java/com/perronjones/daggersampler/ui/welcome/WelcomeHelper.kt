package com.perronjones.daggersampler.ui.welcome

import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.di.ComponentProvider
import com.perronjones.daggersampler.di.welcome.WelcomeComponent

class WelcomeHelper(private val appContext: DaggerSamplerApp) {
    fun setComponent() {
        val welcomeComponent = appContext.appComponent.getWelcomeComponentFactory().create()
        appContext.setWelcomeComponent(object : ComponentProvider<WelcomeComponent> {
            override fun provideComponent(): WelcomeComponent? = welcomeComponent
        })
    }

    fun unsetComponent() {
        appContext.setWelcomeComponent(null)
    }

    fun injectDependencies(welcomeFragment: WelcomeFragment) {
        appContext.getWelcomeComponent()?.inject(welcomeFragment)
    }
}