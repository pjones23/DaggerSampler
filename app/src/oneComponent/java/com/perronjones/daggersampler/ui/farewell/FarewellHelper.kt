package com.perronjones.daggersampler.ui.farewell

import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.di.APP
import com.perronjones.daggersampler.di.DEFINITION
import com.perronjones.daggersampler.di.FRENCH
import com.perronjones.daggersampler.di.SPANISH
import com.perronjones.daggersampler.info.InfoProvider
import com.perronjones.daggersampler.info.farewell.FarewellDefinitionInfoProvider
import com.perronjones.daggersampler.info.farewell.FrenchFarewellInfoProvider
import com.perronjones.daggersampler.info.farewell.SpanishFarewellInfoProvider
import javax.inject.Inject
import javax.inject.Named

class FarewellHelper(appContext: DaggerSamplerApp) {

    init {
        appContext.appComponent.inject(this)
    }

    @field:[Inject Named(DEFINITION)]
    lateinit var farewellDefinitionInfoProvider: FarewellDefinitionInfoProvider

    @field:[Inject Named(APP)]
    lateinit var appMessageTxtInfoProvider: InfoProvider

    @field:[Inject Named(FRENCH)]
    lateinit var frenchFarewellInfoProvider: FrenchFarewellInfoProvider

    @field:[Inject Named(SPANISH)]
    lateinit var spanishFarewellInfoProvider: SpanishFarewellInfoProvider

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

    fun injectDependencies(farewellFragment: FarewellFragment) {
        farewellFragment.infoProvider = farewellDefinitionInfoProvider
        farewellFragment.appMessageTxtInfoProvider = appMessageTxtInfoProvider
    }

    fun injectDependencies(frenchFarewellFragment: FrenchFarewellFragment) {
        frenchFarewellFragment.messageInfoProvider = frenchFarewellInfoProvider
        frenchFarewellFragment.definitionInfoProvider = farewellDefinitionInfoProvider
        frenchFarewellFragment.appMessageTxtInfoProvider = appMessageTxtInfoProvider
    }

    fun injectDependencies(spanishFarewellFragment: SpanishFarewellFragment) {
        spanishFarewellFragment.messageInfoProvider = spanishFarewellInfoProvider
        spanishFarewellFragment.definitionInfoProvider = farewellDefinitionInfoProvider
        spanishFarewellFragment.appMessageTxtInfoProvider = appMessageTxtInfoProvider
    }
}