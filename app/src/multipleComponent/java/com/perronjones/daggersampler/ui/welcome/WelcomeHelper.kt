package com.perronjones.daggersampler.ui.welcome

import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.di.ComponentProvider
import com.perronjones.daggersampler.di.welcome.WelcomeComponent

class WelcomeHelper {
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

    fun injectDependencies(appContext: DaggerSamplerApp, welcomeFragment: WelcomeFragment) {
        appContext.getWelcomeComponent()?.inject(welcomeFragment)
    }
}