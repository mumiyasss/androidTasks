package com.mumiyasss.profile.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mumiyasss.profile.Profile
import com.mumiyasss.profile.R


class EditFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_edit, container, false)

        return view
    }

    companion object {
        const val EXTRA_PROFILE = "profile"
    }
}