package com.perronjones.daggersampler

import com.perronjones.daggersampler.di.AppComponent
import com.perronjones.daggersampler.di.ComponentProvider
import com.perronjones.daggersampler.di.farewell.DaggerFarewellComponent
import com.perronjones.daggersampler.di.farewell.FarewellComponent
import com.perronjones.daggersampler.di.greeting.DaggerGreetingComponent
import com.perronjones.daggersampler.di.greeting.GreetingComponent
import com.perronjones.daggersampler.di.welcome.DaggerWelcomeComponent
import com.perronjones.daggersampler.di.welcome.WelcomeComponent

class DaggerSamplerAppHelper {
    fun initializeComponents(appContext: DaggerSamplerApp, appComponent: AppComponent) {
        val welcomeComponent = DaggerWelcomeComponent.builder().appComponent(appComponent).build()
        appContext.setWelcomeComponent(object : ComponentProvider<WelcomeComponent> {
            override fun provideComponent(): WelcomeComponent? = welcomeComponent
        })

        val greetingComponent = DaggerGreetingComponent.builder().appComponent(appComponent).build()
        appContext.setGreetingComponent(object : ComponentProvider<GreetingComponent> {
            override fun provideComponent(): GreetingComponent? = greetingComponent
        })

        val farewellComponent = DaggerFarewellComponent.builder().appComponent(appComponent).build()
        appContext.setFarewellComponent(object : ComponentProvider<FarewellComponent> {
            override fun provideComponent(): FarewellComponent? = farewellComponent
        })
    }
}