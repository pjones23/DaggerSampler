package com.perronjones.daggersampler.ui.greeting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.R
import com.perronjones.daggersampler.di.ComponentProvider
import com.perronjones.daggersampler.di.greeting.GreetingComponent

class GreetingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appContext = DaggerSamplerApp.getAppContext()
        val greetingComponent = appContext.appComponent!!.getGreetingComponentFactory().create()
        appContext.setGreetingComponent(object : ComponentProvider<GreetingComponent> {
            override fun provideComponent(): GreetingComponent? = greetingComponent
        })
        setContentView(R.layout.greeting_activity)
    }

    override fun onDestroy() {
        DaggerSamplerApp.getAppContext().setGreetingComponent(null)
        super.onDestroy()
    }
}