package com.perronjones.daggersampler.di.welcome

import com.perronjones.daggersampler.ui.welcome.WelcomeFragment

interface BaseWelcomeComponent {
    fun inject(welcomeFragment: WelcomeFragment)
}