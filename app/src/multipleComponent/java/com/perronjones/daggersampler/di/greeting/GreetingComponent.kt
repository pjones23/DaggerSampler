package com.perronjones.daggersampler.di.greeting

import com.perronjones.daggersampler.di.AppComponent
import com.perronjones.daggersampler.di.GreetingScope
import dagger.Component

@GreetingScope
@Component(dependencies = [AppComponent::class], modules = [GreetingModule::class])
interface GreetingComponent: BaseGreetingComponent