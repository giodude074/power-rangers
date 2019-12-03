package com.example.android.petfindr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.android.petfindr.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?):View? {
        val binding: FragmentDetailsBinding =  DataBindingUtil.inflate(
                inflater, R.layout.fragment_details, container, false)

        binding.homeButton.setOnClickListener{ view: View ->
            Navigation.findNavController(view).navigate(R.id.action_detailsFragment_to_titleFragment)
        }
        return binding.root
    }
}