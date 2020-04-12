package com.perronjones.daggersampler.ui.welcome

import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.di.ComponentProvider
import com.perronjones.daggersampler.di.welcome.WelcomeComponent

class WelcomeHelper {
    fun setComponent(appContext: DaggerSamplerApp) {
        val welcomeComponent = appContext.appComponent.getWelcomeComponentFactory().create()
        appContext.setWelcomeComponent(object : ComponentProvider<WelcomeComponent> {
            override fun provideComponent(): WelcomeComponent? = welcomeComponent
        })
    }

    fun unsetComponent(appContext: DaggerSamplerApp) {
        appContext.setWelcomeComponent(null)
    }

    fun injectDependencies(appContext: DaggerSamplerApp, welcomeFragment: WelcomeFragment) {
        appContext.getWelcomeComponent()?.inject(welcomeFragment)
    }
}