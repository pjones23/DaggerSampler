package com.perronjones.daggersampler.di

import com.perronjones.daggersampler.di.farewell.FarewellModule
import com.perronjones.daggersampler.di.greeting.GreetingModule
import com.perronjones.daggersampler.di.welcome.BaseWelcomeComponent
import com.perronjones.daggersampler.di.welcome.WelcomeModule
import com.perronjones.daggersampler.info.InfoProvider
import com.perronjones.daggersampler.ui.farewell.FarewellHelper
import com.perronjones.daggersampler.ui.greeting.GreetingHelper
import com.perronjones.daggersampler.ui.welcome.WelcomeHelper
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, FarewellModule::class, GreetingModule::class, WelcomeModule::class])
interface AppComponent: BaseWelcomeComponent {
    fun inject(greetingHelper: GreetingHelper)
    fun inject(farewellHelper: FarewellHelper)
    fun inject(welcomeHelper: WelcomeHelper)

    @Named(APP)
    fun getAppProviderInfo(): InfoProvider
}