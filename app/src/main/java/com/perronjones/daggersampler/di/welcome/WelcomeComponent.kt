package com.perronjones.daggersampler.di.welcome

import com.perronjones.daggersampler.di.WelcomeScope
import com.perronjones.daggersampler.ui.welcome.WelcomeActivity
import com.perronjones.daggersampler.ui.welcome.WelcomeFragment
import dagger.Subcomponent

@WelcomeScope
@Subcomponent(modules = [WelcomeModule::class])
interface WelcomeComponent {
    fun inject(welcomeFragment: WelcomeFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): WelcomeComponent
    }
}