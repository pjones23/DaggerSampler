package com.perronjones.daggersampler.di.farewell

import com.perronjones.daggersampler.di.FarewellScope
import dagger.Subcomponent

@FarewellScope
@Subcomponent(modules = [FarewellModule::class])
interface FarewellComponent: BaseFarewellComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): FarewellComponent
    }
}