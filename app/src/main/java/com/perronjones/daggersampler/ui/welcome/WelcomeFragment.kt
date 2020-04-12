package com.perronjones.daggersampler.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.R
import com.perronjones.daggersampler.di.APP
import com.perronjones.daggersampler.di.DEFINITION
import com.perronjones.daggersampler.di.FAREWELL
import com.perronjones.daggersampler.di.GREETING
import com.perronjones.daggersampler.info.InfoProvider
import com.perronjones.daggersampler.ui.TwoCardFragment
import javax.inject.Inject
import javax.inject.Named

class WelcomeFragment : TwoCardFragment() {
    @field:[Inject Named(DEFINITION)]
    lateinit var definitionInfoProvider: InfoProvider

    @field:[Inject Named(FAREWELL)]
    lateinit var farewellTitleTxtInfoProvider: InfoProvider

    @field:[Inject Named(GREETING)]
    lateinit var greetingTitleTxtInfoProvider: InfoProvider

    @field:[Inject Named(APP)]
    lateinit var appMessageTxtInfoProvider: InfoProvider

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.two_card_layout, container, false)
    }

    override fun createView(view: View) {
        createView(view, greetingTitleTxtInfoProvider.provideInfo(), farewellTitleTxtInfoProvider.provideInfo(),
            this, definitionInfoProvider.provideInfo(), appMessageTxtInfoProvider.provideInfo())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val welcomeComponent = DaggerSamplerApp.getAppContext().getWelcomeComponent()
        welcomeComponent?.inject(this)
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        /*
        finishing activity so the onDestroy of the Welcome activity triggers and WelcomeComponent is cleaned up for
        memory demonstrations purposes
         */
        activity?.finish()
    }

    override fun getCardOneDirections(): NavDirections = WelcomeFragmentDirections.actionWelcomeFragmentToGreetingActivity()

    override fun getCardTwoDirections(): NavDirections = WelcomeFragmentDirections.actionWelcomeFragmentToFarewellActivity()
}
