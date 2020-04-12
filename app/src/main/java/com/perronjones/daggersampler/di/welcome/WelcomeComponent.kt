package com.perronjones.daggersampler.di.welcome

import com.perronjones.daggersampler.ui.welcome.WelcomeFragment
import dagger.Subcomponent

@Subcomponent(modules = [WelcomeModule::class])
interface WelcomeComponent {
    fun inject(welcomeFragment: WelcomeFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): WelcomeComponent
    }
}