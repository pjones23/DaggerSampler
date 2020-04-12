package com.perronjones.daggersampler.ui.farewell

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
import com.perronjones.daggersampler.info.InfoProvider
import javax.inject.Inject
import javax.inject.Named

class FarewellFragment: Fragment(), View.OnClickListener {
    @field:[Inject Named(DEFINITION)]
    lateinit var infoProvider: InfoProvider

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.two_card_layout, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<MaterialTextView>(R.id.description).text = infoProvider.provideInfo()
        val frenchFarewellCardView = view.findViewById<MaterialCardView>(R.id.card_one)
        frenchFarewellCardView.isClickable = true
        frenchFarewellCardView.setOnClickListener(this)
        val frenchFarewellTitle = view.findViewById<MaterialTextView>(R.id.card_one_title)
        frenchFarewellTitle.text = getText(R.string.french)
        val spanishFarewellCardView = view.findViewById<MaterialCardView>(R.id.card_two)
        spanishFarewellCardView.isClickable = true
        spanishFarewellCardView.setOnClickListener(this)
        val spanishFarewellTitle = view.findViewById<MaterialTextView>(R.id.card_two_title)
        spanishFarewellTitle.text = getText(R.string.spanish)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val farewellComponent = DaggerSamplerApp.getAppContext().getFarewellComponent()
        farewellComponent?.inject(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.card_one -> {
                findNavController().navigate(FarewellFragmentDirections.actionFarewellFragmentToFrenchFarewellFragment())
            }
            R.id.card_two -> {
                findNavController().navigate(FarewellFragmentDirections.actionFarewellFragmentToSpanishFarewellFragment())
            }
        }
    }
}