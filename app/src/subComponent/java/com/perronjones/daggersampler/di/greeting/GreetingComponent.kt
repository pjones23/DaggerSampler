package com.perronjones.daggersampler.di.greeting

import com.perronjones.daggersampler.di.GreetingScope
import dagger.Subcomponent

@GreetingScope
@Subcomponent(modules = [GreetingModule::class])
interface GreetingComponent: BaseGreetingComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): GreetingComponent
    }
}