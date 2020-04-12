package com.perronjones.daggersampler.ui.greeting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.textview.MaterialTextView
import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.R
import com.perronjones.daggersampler.di.FRENCH
import com.perronjones.daggersampler.info.InfoProvider
import javax.inject.Inject
import javax.inject.Named

class FrenchGreetingFragment : Fragment() {

    @field:[Inject Named(FRENCH)]
    lateinit var infoProvider: InfoProvider

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.message_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<MaterialTextView>(R.id.messageTxt).text = infoProvider.provideInfo()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val greetingComponent = DaggerSamplerApp.getAppContext().getGreetingComponent()
        greetingComponent?.inject(this)
    }

}
