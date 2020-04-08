package com.perronjones.daggersampler.di

import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class WelcomeScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class GreetingScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FarewellScope