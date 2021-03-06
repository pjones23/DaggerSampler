package com.perronjones.daggersampler.ui.welcome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.R

class WelcomeActivity : AppCompatActivity() {

    private lateinit var helper: WelcomeHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        helper = WelcomeHelper(DaggerSamplerApp.getAppContext())
        helper.setComponent()
        setContentView(R.layout.welcome_activity)
    }

    override fun onDestroy() {
        helper.unsetComponent()
        super.onDestroy()
    }
}
