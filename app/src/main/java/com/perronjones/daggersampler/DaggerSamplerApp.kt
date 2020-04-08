package com.perronjones.daggersampler

import android.app.Application
import com.perronjones.daggersampler.di.AppComponent
import com.perronjones.daggersampler.di.DaggerAppComponent
import com.perronjones.daggersampler.di.farewell.FarewellComponent
import com.perronjones.daggersampler.di.greeting.GreetingComponent
import com.perronjones.daggersampler.di.welcome.WelcomeComponent
import java.lang.ref.WeakReference

class DaggerSamplerApp: Application() {

    var appComponent: AppComponent? = null
        private set

    private var welcomeComponent: WeakReference<WelcomeComponent>? = null
    private var farewellComponent: WeakReference<FarewellComponent>? = null
    private var greetingComponent: WeakReference<GreetingComponent>? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder().build()
    }

    fun getWelcomeComponent(): WelcomeComponent? = welcomeComponent?.get()

    fun setWelcomeComponent(component: WelcomeComponent?) {
        if (null != component) {
            welcomeComponent = WeakReference<WelcomeComponent>(component)
        } else {
            welcomeComponent?.clear()
        }
    }

    fun getFarewellComponent(): FarewellComponent? = farewellComponent?.get()

    fun setFarewellComponent(component: FarewellComponent?) {
        if (null != component) {
            farewellComponent = WeakReference<FarewellComponent>(component)
        } else {
            farewellComponent?.clear()
        }
    }

    fun getGreetingComponent(): GreetingComponent? = greetingComponent?.get()

    fun setGreetingComponent(component: GreetingComponent?) {
        if (null != component) {
            greetingComponent = WeakReference<GreetingComponent>(component)
        } else {
            greetingComponent?.clear()
        }
    }

    companion object {
        private lateinit var instance: DaggerSamplerApp

        // no one can possibly use this before onCreate, unless Direct Boot... and we don't care for this sample app
        fun getAppContext(): DaggerSamplerApp = instance
    }
}