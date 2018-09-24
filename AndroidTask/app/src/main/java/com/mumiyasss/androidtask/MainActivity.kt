package com.mumiyasss.androidtask

import android.support.v4.app.Fragment

class MainActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment {
        return MainFragment()
    }
}
