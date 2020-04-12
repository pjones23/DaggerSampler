package com.perronjones.daggersampler.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.textview.MaterialTextView
import com.perronjones.daggersampler.R
import com.perronjones.daggersampler.di.APP
import com.perronjones.daggersampler.di.DEFINITION
import com.perronjones.daggersampler.info.InfoProvider
import javax.inject.Inject
import javax.inject.Named

abstract class MessageFragment: Fragment() {

    @field:[Inject Named(DEFINITION)]
    lateinit var definitionInfoProvider: InfoProvider

    @field:[Inject Named(APP)]
    lateinit var appMessageTxtInfoProvider: InfoProvider

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<MaterialTextView>(R.id.messageHeadingTxt).text = definitionInfoProvider.provideInfo()
        view.findViewById<MaterialTextView>(R.id.messageTxt).text = getMessageText()
        view.findViewById<MaterialTextView>(R.id.message_app_message_txt).text = appMessageTxtInfoProvider.provideInfo()
    }

    abstract fun getMessageText() : String
}