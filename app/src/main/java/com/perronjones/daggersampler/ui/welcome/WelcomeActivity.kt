package com.perronjones.daggersampler.ui.welcome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.R
import com.perronjones.daggersampler.ui.greeting.FrenchGreetingFragment

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appContext = DaggerSamplerApp.getAppContext()
        val welcomeComponent = appContext.appComponent!!.getWelcomeComponentFactory().create()
        appContext.setWelcomeComponent(welcomeComponent)
        setContentView(R.layout.welcome_activity)
    }

    override fun onDestroy() {
        DaggerSamplerApp.getAppContext().setWelcomeComponent(null)
        super.onDestroy()
    }
}
