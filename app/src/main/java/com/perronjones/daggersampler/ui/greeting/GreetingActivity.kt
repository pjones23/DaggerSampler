package com.perronjones.daggersampler.ui.greeting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.R

class GreetingActivity : AppCompatActivity() {

    private lateinit var helper: GreetingHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        helper = GreetingHelper(DaggerSamplerApp.getAppContext())
        helper.setComponent()
        setContentView(R.layout.greeting_activity)
    }

    override fun onDestroy() {
        helper.unsetComponent()
        super.onDestroy()
    }
}