package com.perronjones.daggersampler.di.welcome

import dagger.Subcomponent

@Subcomponent(modules = [WelcomeModule::class])
interface WelcomeComponent : BaseWelcomeComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): WelcomeComponent
    }
}