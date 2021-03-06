package com.perronjones.daggersampler.ui.greeting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.R
import com.perronjones.daggersampler.info.AppInfoProvider
import com.perronjones.daggersampler.info.greeting.GreetingDefinitionInfoProvider
import com.perronjones.daggersampler.ui.TwoCardFragment
import javax.inject.Inject

class GreetingFragment: TwoCardFragment() {

    @Inject
    lateinit var infoProvider: GreetingDefinitionInfoProvider

    @Inject
    lateinit var appMessageTxtInfoProvider: AppInfoProvider

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.two_card_layout, container, false)
    }

    override fun createView(view: View) {
        createView(view, getText(R.string.french).toString(), getText(R.string.spanish).toString(),
            this, infoProvider.provideInfo(), appMessageTxtInfoProvider.provideInfo())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GreetingHelper(DaggerSamplerApp.getAppContext()).injectDependencies(this)
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            /*
            navigating to the WelcomeActivity activity since it was finished due to the WelcomeComponent being cleaned up for
            memory demonstrations purposes.
             */
            findNavController().navigate(GreetingFragmentDirections.actionGreetingFragmentToWelcomeActivity())
            // Finishing here, to mimic would would have happened if the onBackPressed behavior was not overwritten
            activity?.finish()
        }
        callback.isEnabled = true
    }

    override fun getCardOneDirections(): NavDirections = GreetingFragmentDirections.actionGreetingFragmentToFrenchGreetingFragment()

    override fun getCardTwoDirections(): NavDirections = GreetingFragmentDirections.actionGreetingFragmentToSpanishGreetingFragment()
}