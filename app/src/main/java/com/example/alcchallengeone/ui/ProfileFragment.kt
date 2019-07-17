package com.example.alcchallengeone.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.alcchallengeone.R

import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onStart() {
        super.onStart()
        Glide.with(iv_profile_picture)
            .load(getImage())
            .into(iv_profile_picture)
    }

    private fun getImage(): Int {

        return resources.getIdentifier("pic00", "drawable", context!!.packageName)
    }

}
