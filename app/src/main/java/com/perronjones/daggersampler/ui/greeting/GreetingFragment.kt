package com.perronjones.daggersampler.ui.greeting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView
import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.R
import com.perronjones.daggersampler.di.DEFINITION
import com.perronjones.daggersampler.info.InfoProvider
import javax.inject.Inject
import javax.inject.Named

class GreetingFragment: Fragment(), View.OnClickListener {

    @field:[Inject Named(DEFINITION)]
    lateinit var infoProvider: InfoProvider

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.two_card_layout, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<MaterialTextView>(R.id.description).text = infoProvider.provideInfo()
        val frenchGreetingCardView = view.findViewById<MaterialCardView>(R.id.card_one)
        frenchGreetingCardView.isClickable = true
        frenchGreetingCardView.setOnClickListener(this)
        val frenchGreetingTitle = view.findViewById<MaterialTextView>(R.id.card_one_title)
        frenchGreetingTitle.text = getText(R.string.french)
        val spanishGreetingCardView = view.findViewById<MaterialCardView>(R.id.card_two)
        spanishGreetingCardView.isClickable = true
        spanishGreetingCardView.setOnClickListener(this)
        val spanishGreetingTitle = view.findViewById<MaterialTextView>(R.id.card_two_title)
        spanishGreetingTitle.text = getText(R.string.spanish)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val greetingComponent = DaggerSamplerApp.getAppContext().getGreetingComponent()
        greetingComponent?.inject(this)
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

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.card_one -> {
                findNavController().navigate(GreetingFragmentDirections.actionGreetingFragmentToFrenchGreetingFragment())
            }
            R.id.card_two -> {
                findNavController().navigate(GreetingFragmentDirections.actionGreetingFragmentToSpanishGreetingFragment())
            }
        }
    }
}