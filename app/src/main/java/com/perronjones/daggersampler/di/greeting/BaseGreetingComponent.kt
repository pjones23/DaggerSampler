package com.perronjones.daggersampler.di.greeting

import com.perronjones.daggersampler.ui.greeting.FrenchGreetingFragment
import com.perronjones.daggersampler.ui.greeting.GreetingFragment
import com.perronjones.daggersampler.ui.greeting.SpanishGreetingFragment

interface BaseGreetingComponent {
    fun inject(frenchGreetingFragment: FrenchGreetingFragment)
    fun inject(spanishGreetingFragment: SpanishGreetingFragment)
    fun inject(greetingFragment: GreetingFragment)
}