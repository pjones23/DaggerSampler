package com.perronjones.daggersampler.di.greeting

import com.perronjones.daggersampler.di.AppComponent
import com.perronjones.daggersampler.di.GreetingScope
import dagger.Component

@GreetingScope
@Component(modules = [GreetingModule::class], dependencies = [AppComponent::class])
interface GreetingComponent: BaseGreetingComponent