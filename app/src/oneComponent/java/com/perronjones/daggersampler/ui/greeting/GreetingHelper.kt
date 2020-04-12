package com.perronjones.daggersampler.ui.greeting

import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.di.APP
import com.perronjones.daggersampler.di.DEFINITION
import com.perronjones.daggersampler.di.FRENCH
import com.perronjones.daggersampler.di.SPANISH
import com.perronjones.daggersampler.info.InfoProvider
import com.perronjones.daggersampler.info.greeting.FrenchGreetingInfoProvider
import com.perronjones.daggersampler.info.greeting.GreetingDefinitionInfoProvider
import com.perronjones.daggersampler.info.greeting.SpanishGreetingInfoProvider
import javax.inject.Inject
import javax.inject.Named

class GreetingHelper(appContext: DaggerSamplerApp) {

    init {
        appContext.appComponent.inject(this)
    }

    @field:[Inject Named(DEFINITION)]
    lateinit var greetingDefinitionInfoProvider: GreetingDefinitionInfoProvider

    @field:[Inject Named(APP)]
    lateinit var appMessageTxtInfoProvider: InfoProvider

    @field:[Inject Named(SPANISH)]
    lateinit var spanishGreetingInfoProvider: SpanishGreetingInfoProvider

    @field:[Inject Named(FRENCH)]
    lateinit var frenchGreetingInfoProvider: FrenchGreetingInfoProvider

    fun setComponent() {
        /*
         Do Nothing, because it was set during app create in the scenario representing multiple components
         that are created in the Application Context
         */
    }

    fun unsetComponent() {
        /*
        Do Nothing, because it will not be unset in the scenario representing multiple components
        that are created in the Application Context since it is tied to the life cycle of the application
         */
    }

    fun injectDependencies(greetingFragment: GreetingFragment) {
        greetingFragment.infoProvider = greetingDefinitionInfoProvider
        greetingFragment.appMessageTxtInfoProvider= appMessageTxtInfoProvider
    }

    fun injectDependencies(frenchGreetingFragment: FrenchGreetingFragment) {
        frenchGreetingFragment.messageInfoProvider = frenchGreetingInfoProvider
        frenchGreetingFragment.appMessageTxtInfoProvider = appMessageTxtInfoProvider
        frenchGreetingFragment.definitionInfoProvider = greetingDefinitionInfoProvider
    }

    fun injectDependencies(spanishGreetingFragment: SpanishGreetingFragment) {
        spanishGreetingFragment.messageInfoProvider = spanishGreetingInfoProvider
        spanishGreetingFragment.appMessageTxtInfoProvider = appMessageTxtInfoProvider
        spanishGreetingFragment.definitionInfoProvider = greetingDefinitionInfoProvider
    }
}