package com.perronjones.daggersampler.di

interface ComponentProvider<T> {
    fun provideComponent() : T?
}