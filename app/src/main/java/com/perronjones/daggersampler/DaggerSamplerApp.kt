package com.perronjones.daggersampler

import android.app.Application
import com.perronjones.daggersampler.di.AppComponent
import com.perronjones.daggersampler.di.ComponentProvider
import com.perronjones.daggersampler.di.DaggerAppComponent
import com.perronjones.daggersampler.di.farewell.FarewellComponent
import com.perronjones.daggersampler.di.greeting.GreetingComponent
import com.perronjones.daggersampler.di.welcome.WelcomeComponent

class DaggerSamplerApp: Application() {

    lateinit var appComponent: AppComponent
        private set

    private var welcomeComponent: ComponentProvider<WelcomeComponent>? = null
    private var farewellComponent: ComponentProvider<FarewellComponent>? = null
    private var greetingComponent: ComponentProvider<GreetingComponent>? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder().build()
        DaggerSamplerAppHelper().initializeComponents(this, appComponent)
    }

    fun getWelcomeComponent(): WelcomeComponent? = welcomeComponent?.provideComponent()

    fun setWelcomeComponent(componentProvider: ComponentProvider<WelcomeComponent>?) {
        welcomeComponent = componentProvider
    }

    fun getFarewellComponent(): FarewellComponent? = farewellComponent?.provideComponent()

    fun setFarewellComponent(componentProvider: ComponentProvider<FarewellComponent>?) {
        farewellComponent = componentProvider
    }

    fun getGreetingComponent(): GreetingComponent? = greetingComponent?.provideComponent()

    fun setGreetingComponent(componentProvider: ComponentProvider<GreetingComponent>?) {
        greetingComponent = componentProvider
    }

    companion object {
        private lateinit var instance: DaggerSamplerApp

        // no one can possibly use this before onCreate, unless Direct Boot... and we don't care for this sample app
        fun getAppContext(): DaggerSamplerApp = instance
    }
}