package com.perronjones.daggersampler.di

import com.perronjones.daggersampler.di.farewell.BaseFarewellComponent
import com.perronjones.daggersampler.di.farewell.FarewellModule
import com.perronjones.daggersampler.di.greeting.BaseGreetingComponent
import com.perronjones.daggersampler.di.greeting.GreetingModule
import com.perronjones.daggersampler.di.welcome.BaseWelcomeComponent
import com.perronjones.daggersampler.di.welcome.WelcomeModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, FarewellModule::class, GreetingModule::class, WelcomeModule::class])
interface AppComponent: BaseWelcomeComponent, BaseFarewellComponent, BaseGreetingComponent