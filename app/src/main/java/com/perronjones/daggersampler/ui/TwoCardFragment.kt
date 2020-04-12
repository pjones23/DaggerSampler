package com.perronjones.daggersampler.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView
import com.perronjones.daggersampler.R

abstract class TwoCardFragment : Fragment(), View.OnClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createView(view)
    }

    abstract fun createView(view: View)

    protected fun createView(view: View, cardOneText: String, cardTwoText: String, onClickListener: View.OnClickListener,
                            headlineTxt: String, appMessageText: String) {
        view.findViewById<MaterialTextView>(R.id.description).text = headlineTxt
        val cardOneCardView = view.findViewById<MaterialCardView>(R.id.card_one)
        cardOneCardView.isClickable = true
        cardOneCardView.setOnClickListener(onClickListener)
        view.findViewById<MaterialTextView>(R.id.card_one_title).text = cardOneText
        val cardTwoCardView = view.findViewById<MaterialCardView>(R.id.card_two)
        cardTwoCardView.isClickable = true
        cardTwoCardView.setOnClickListener(onClickListener)
        view.findViewById<MaterialTextView>(R.id.card_two_title).text = cardTwoText
        view.findViewById<MaterialTextView>(R.id.two_card_app_message).text = appMessageText
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.card_one -> {
                findNavController().navigate(getCardOneDirections())
            }
            R.id.card_two -> {
                findNavController().navigate(getCardTwoDirections())
            }
        }
    }

    abstract fun getCardOneDirections() : NavDirections
    abstract fun getCardTwoDirections() : NavDirections
}