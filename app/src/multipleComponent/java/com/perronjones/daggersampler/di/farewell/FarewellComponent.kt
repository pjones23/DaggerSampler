package com.perronjones.daggersampler.di.farewell

import com.perronjones.daggersampler.di.AppComponent
import com.perronjones.daggersampler.di.FarewellScope
import dagger.Component

@FarewellScope
@Component(dependencies = [AppComponent::class], modules = [FarewellModule::class])
interface FarewellComponent: BaseFarewellComponent