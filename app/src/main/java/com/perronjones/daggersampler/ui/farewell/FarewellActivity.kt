package com.perronjones.daggersampler.ui.farewell

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.R
import com.perronjones.daggersampler.di.ComponentProvider
import com.perronjones.daggersampler.di.DEFINITION
import com.perronjones.daggersampler.di.farewell.FarewellComponent
import javax.inject.Inject
import javax.inject.Named

class FarewellActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appContext = DaggerSamplerApp.getAppContext()
        val farewellComponent = appContext.appComponent!!.getFarewellComponentFactory().create()
        appContext.setFarewellComponent(object : ComponentProvider<FarewellComponent> {
            override fun provideComponent(): FarewellComponent? = farewellComponent
        })
        setContentView(R.layout.farewell_activity)
    }

    override fun onDestroy() {
        DaggerSamplerApp.getAppContext().setFarewellComponent(null)
        super.onDestroy()
    }
}