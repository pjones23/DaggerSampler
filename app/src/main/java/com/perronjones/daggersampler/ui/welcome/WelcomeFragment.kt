package com.perronjones.daggersampler.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView
import com.perronjones.daggersampler.DaggerSamplerApp
import com.perronjones.daggersampler.R
import com.perronjones.daggersampler.di.DEFINITION
import com.perronjones.daggersampler.di.FAREWELL
import com.perronjones.daggersampler.di.GREETING
import com.perronjones.daggersampler.info.InfoProvider
import javax.inject.Inject
import javax.inject.Named

class WelcomeFragment : Fragment(), View.OnClickListener {
    @field:[Inject Named(DEFINITION)]
    lateinit var definitionInfoProvider: InfoProvider

    @field:[Inject Named(FAREWELL)]
    lateinit var farewellTitleTxtInfoProvider: InfoProvider

    @field:[Inject Named(GREETING)]
    lateinit var greetingTitleTxtInfoProvider: InfoProvider

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.two_card_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val description = view.findViewById<MaterialTextView>(R.id.description)
        description.text = definitionInfoProvider.provideInfo()
        val greetingCardView = view.findViewById<MaterialCardView>(R.id.card_one)
        greetingCardView.isClickable = true
        greetingCardView.setOnClickListener(this)
        val greetingTitle = view.findViewById<MaterialTextView>(R.id.card_one_title)
        greetingTitle.text = greetingTitleTxtInfoProvider.provideInfo()
        val farewellCardView = view.findViewById<MaterialCardView>(R.id.card_two)
        farewellCardView.isClickable = true
        farewellCardView.setOnClickListener(this)
        val farewellTitle = view.findViewById<MaterialTextView>(R.id.card_two_title)
        farewellTitle.text = farewellTitleTxtInfoProvider.provideInfo()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val welcomeComponent = DaggerSamplerApp.getAppContext().getWelcomeComponent()
        welcomeComponent?.inject(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.card_one -> {
                findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToGreetingActivity())
            }
            R.id.card_two -> {
                findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToFarewellActivity())
            }
        }
    }
}
