package com.perronjones.daggersampler.di.farewell

import com.perronjones.daggersampler.di.FarewellScope
import com.perronjones.daggersampler.ui.farewell.FarewellActivity
import com.perronjones.daggersampler.ui.farewell.FarewellFragment
import com.perronjones.daggersampler.ui.farewell.FrenchFarewellFragment
import com.perronjones.daggersampler.ui.farewell.SpanishFarewellFragment
import dagger.Subcomponent

@FarewellScope
@Subcomponent(modules = [FarewellModule::class])
interface FarewellComponent {
    fun inject(frenchFarewellFragment: FrenchFarewellFragment)
    fun inject(spanishFarewellFragment: SpanishFarewellFragment)
    fun inject(farewellFragment: FarewellFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): FarewellComponent
    }
}