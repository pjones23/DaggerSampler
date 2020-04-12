package com.perronjones.daggersampler.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.textview.MaterialTextView
import com.perronjones.daggersampler.R
import com.perronjones.daggersampler.info.AppInfoProvider
import javax.inject.Inject

abstract class MessageFragment: Fragment() {

    @Inject
    lateinit var appMessageTxtInfoProvider: AppInfoProvider

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<MaterialTextView>(R.id.messageHeadingTxt).text = getHeadingText()
        view.findViewById<MaterialTextView>(R.id.messageTxt).text = getMessageText()
        view.findViewById<MaterialTextView>(R.id.message_app_message_txt).text = appMessageTxtInfoProvider.provideInfo()
    }

    abstract fun getMessageText() : String
    abstract fun getHeadingText() : String
}