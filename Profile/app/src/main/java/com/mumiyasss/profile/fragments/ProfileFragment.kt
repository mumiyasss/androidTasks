package com.mumiyasss.profile.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import com.mumiyasss.profile.Profile
import com.mumiyasss.profile.R
import com.mumiyasss.profile.activities.EditActivity
import kotlinx.android.synthetic.main.fragment_profile.view.*


class ProfileFragment : Fragment() {
    private lateinit var profile: Profile
    private lateinit var v: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_profile, container, false)
        profile = Profile("Kolya", "Grebnev", "18", "+7 (800) 555 35-35",
                "@ksftx", "@nikolaygrebnev")
        v.share.setOnClickListener {
            var i = Intent(Intent.ACTION_SEND)
            i.type = "text/plain"
            i.putExtra(Intent.EXTRA_SUBJECT, "My Profile")
            i.putExtra(Intent.EXTRA_TEXT, profile.toString() )
            i = Intent.createChooser(i, "Share your profile via")
            startActivity(i)
        }
        updateUI(profile)
        return v
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_profile, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.edit_profile -> {
                val intent = EditActivity.newIntent(activity!!, profile)
                activity!!.startActivityForResult(intent, EDIT_PROFILE)
                true
            }
            else -> false
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                EDIT_PROFILE -> {
                    profile = data!!.getSerializableExtra(EditFragment.EXTRA_PROFILE) as Profile
                    updateUI(profile)
                }
            }
        }
    }

    private fun updateUI(profile: Profile) {
        v.name.text = profile.firstName + " " + profile.lastName
        v.age.text = profile.age
        v.phone.text = profile.phone
        v.vk.text = profile.vk
        v.inst.text = profile.inst

    }

    companion object {
        private const val EDIT_PROFILE = 1

    }
}