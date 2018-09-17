package com.mumiyasss.profile.activities

import android.content.Intent
import android.support.v4.app.Fragment
import com.mumiyasss.profile.fragments.ProfileFragment

class ProfileActivity : SingleFragmentActivity() {
    private lateinit var fragment: ProfileFragment

    override fun createFragment(): Fragment {
        fragment = ProfileFragment()
        return fragment
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        fragment.onActivityResult(requestCode, resultCode, data)
    }
}
