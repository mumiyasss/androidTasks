package com.mumiyasss.profile.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import com.mumiyasss.profile.Profile
import com.mumiyasss.profile.R
import kotlinx.android.synthetic.main.fragment_edit.view.*


class EditFragment : Fragment() {
    private lateinit var v: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_edit, container, false)

        return v
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_edit, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.submit -> {

                val profile  =  Profile(v.eFirstName.text.toString(),
                                        v.eLastName.text.toString(),
                                        v.eAge.text.toString(),
                                        v.ePhone.text.toString(),
                                        v.eInst.text.toString(),
                                        v.eVk.text.toString())

                val resultingData = Intent()
                resultingData.putExtra(EXTRA_PROFILE, profile)
                activity!!.setResult(Activity.RESULT_OK, resultingData)
                activity!!.finish()
                true
            }
            else -> false
        }
    }

    companion object {
        const val EXTRA_PROFILE = "profile"
    }
}
