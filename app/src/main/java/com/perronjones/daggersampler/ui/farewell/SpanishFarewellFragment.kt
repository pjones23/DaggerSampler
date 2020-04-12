package com.perronjones.daggersampler.ui.farewell

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.R
import com.perronjones.daggersampler.info.farewell.FarewellDefinitionInfoProvider
import com.perronjones.daggersampler.info.farewell.SpanishFarewellInfoProvider
import com.perronjones.daggersampler.ui.MessageFragment
import javax.inject.Inject

class SpanishFarewellFragment: MessageFragment() {

    @Inject
    lateinit var definitionInfoProvider: FarewellDefinitionInfoProvider

    @Inject
    lateinit var messageInfoProvider: SpanishFarewellInfoProvider

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.message_fragment, container, false)
    }

    override fun getMessageText(): String = messageInfoProvider.provideInfo()
    override fun getHeadingText(): String = definitionInfoProvider.provideInfo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FarewellHelper(DaggerSamplerApp.getAppContext()).injectDependencies(this)
    }
}