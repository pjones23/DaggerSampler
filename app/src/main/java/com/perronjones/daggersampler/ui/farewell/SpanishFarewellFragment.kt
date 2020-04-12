package com.perronjones.daggersampler.ui.farewell

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.R
import com.perronjones.daggersampler.di.SPANISH
import com.perronjones.daggersampler.info.InfoProvider
import com.perronjones.daggersampler.ui.MessageFragment
import javax.inject.Inject
import javax.inject.Named

class SpanishFarewellFragment: MessageFragment() {

    @field:[Inject Named(SPANISH)]
    lateinit var messageInfoProvider: InfoProvider

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.message_fragment, container, false)
    }

    override fun getMessageText(): String = messageInfoProvider.provideInfo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FarewellHelper(DaggerSamplerApp.getAppContext()).injectDependencies(this)
    }
}