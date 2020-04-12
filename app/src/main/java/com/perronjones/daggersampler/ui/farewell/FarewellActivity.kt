package com.perronjones.daggersampler.ui.farewell

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.R

class FarewellActivity: AppCompatActivity() {

    private lateinit var helper: FarewellHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        helper = FarewellHelper()
        helper.setComponent(DaggerSamplerApp.getAppContext())
        setContentView(R.layout.farewell_activity)
    }

    override fun onDestroy() {
        helper.unsetComponent(DaggerSamplerApp.getAppContext())
        super.onDestroy()
    }
}