package com.perronjones.daggersampler.di.farewell

import com.perronjones.daggersampler.ui.farewell.FarewellFragment
import com.perronjones.daggersampler.ui.farewell.FrenchFarewellFragment
import com.perronjones.daggersampler.ui.farewell.SpanishFarewellFragment

interface BaseFarewellComponent {
    fun inject(frenchFarewellFragment: FrenchFarewellFragment)
    fun inject(spanishFarewellFragment: SpanishFarewellFragment)
    fun inject(farewellFragment: FarewellFragment)


}