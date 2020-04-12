package com.perronjones.daggersampler.di.welcome

import com.perronjones.daggersampler.di.AppComponent
import dagger.Component
import javax.inject.Scope

@WelcomeScope
@Component(dependencies = [AppComponent::class], modules = [WelcomeModule::class])
interface WelcomeComponent : BaseWelcomeComponent

/*
[com.perronjones.daggersampler.di.greeting.GreetingComponent]/Users/perronj/Development/DaggerSampler/app/build/tmp/kapt3/stubs/multipleComponentDebug/com/perronjones/daggersampler/di/welcome/WelcomeComponent.java:6: error: com.perronjones.daggersampler.di.welcome.WelcomeComponent (unscoped) cannot depend on scoped components
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class WelcomeScope