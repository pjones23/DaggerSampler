package com.perronjones.daggersampler.di

import com.perronjones.daggersampler.di.farewell.FarewellComponent
import com.perronjones.daggersampler.di.greeting.GreetingComponent
import com.perronjones.daggersampler.di.welcome.WelcomeComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun getWelcomeComponentFactory(): WelcomeComponent.Factory
    fun getGreetingComponentFactory(): GreetingComponent.Factory
    fun getFarewellComponentFactory(): FarewellComponent.Factory
}