package com.example.petfindr

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.petfindr.databinding.FragmentPostBinding

class CreateFragment : Fragment() {
    // TODO: Rename and change types of parameters
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPostBinding>(
            inflater,
            R.layout.fragment_post,
            container,
            false
        )

        //



        // Inflate the layout for this fragment

        return binding.root
    }








}
