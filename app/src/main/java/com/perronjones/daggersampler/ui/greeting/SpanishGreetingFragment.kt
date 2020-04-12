package com.perronjones.daggersampler.ui.greeting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.R
import com.perronjones.daggersampler.info.greeting.GreetingDefinitionInfoProvider
import com.perronjones.daggersampler.info.greeting.SpanishGreetingInfoProvider
import com.perronjones.daggersampler.ui.MessageFragment
import javax.inject.Inject

class SpanishGreetingFragment : MessageFragment() {

    @Inject
    lateinit var definitionInfoProvider: GreetingDefinitionInfoProvider

    @Inject
    lateinit var messageInfoProvider: SpanishGreetingInfoProvider

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.message_fragment, container, false)
    }

    override fun getMessageText(): String = messageInfoProvider.provideInfo()
    override fun getHeadingText(): String = definitionInfoProvider.provideInfo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GreetingHelper(DaggerSamplerApp.getAppContext()).injectDependencies(this)
    }
}