package com.mumiyasss.profile.activities

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.mumiyasss.profile.Profile
import com.mumiyasss.profile.fragments.EditFragment


class EditActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment {
        return EditFragment()
    }

    companion object {
        private const val ARG_PROFILE = "profile"

        fun newIntent(packageContext: Context, profile: Profile): Intent {
            val intent = Intent(packageContext, EditActivity::class.java)
            intent.putExtra(ARG_PROFILE, profile)
            return intent
        }
    }
}