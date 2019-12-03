package com.example.android.petfindr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.android.petfindr.databinding.FragmentPostBinding

class PostFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?):View? {
        val binding: FragmentPostBinding =  DataBindingUtil.inflate(
                inflater, R.layout.fragment_post, container, false)
        return binding.root
    }
}