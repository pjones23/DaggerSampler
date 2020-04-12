package com.perronjones.daggersampler.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.R
import com.perronjones.daggersampler.info.AppInfoProvider
import com.perronjones.daggersampler.info.welcome.FarewellWelcomeTitleInfoProvider
import com.perronjones.daggersampler.info.welcome.GreetingWelcomeTitleInfoProvider
import com.perronjones.daggersampler.info.welcome.WelcomeDefinitionInfoProvider
import com.perronjones.daggersampler.ui.TwoCardFragment
import javax.inject.Inject

class WelcomeFragment : TwoCardFragment() {

    @Inject
    lateinit var definitionInfoProvider: WelcomeDefinitionInfoProvider

    @Inject
    lateinit var farewellTitleTxtInfoProvider: FarewellWelcomeTitleInfoProvider

    @Inject
    lateinit var greetingTitleTxtInfoProvider: GreetingWelcomeTitleInfoProvider

    @Inject
    lateinit var appMessageTxtInfoProvider: AppInfoProvider

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
        WelcomeHelper(DaggerSamplerApp.getAppContext()).injectDependencies(this)
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
