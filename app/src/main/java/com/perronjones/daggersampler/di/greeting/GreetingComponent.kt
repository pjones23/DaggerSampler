package com.perronjones.daggersampler.di.greeting

import com.perronjones.daggersampler.di.GreetingScope
import com.perronjones.daggersampler.ui.greeting.FrenchGreetingFragment
import com.perronjones.daggersampler.ui.greeting.GreetingActivity
import com.perronjones.daggersampler.ui.greeting.GreetingFragment
import com.perronjones.daggersampler.ui.greeting.SpanishGreetingFragment
import dagger.Subcomponent

@GreetingScope
@Subcomponent(modules = [GreetingModule::class])
interface GreetingComponent {
    fun inject(frenchGreetingFragment: FrenchGreetingFragment)
    fun inject(spanishGreetingFragment: SpanishGreetingFragment)
    fun inject(greetingFragment: GreetingFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): GreetingComponent
    }
}