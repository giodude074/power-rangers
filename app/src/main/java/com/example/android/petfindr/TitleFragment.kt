package com.example.android.petfindr


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.android.petfindr.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?):View? {
        val binding: FragmentTitleBinding =  DataBindingUtil.inflate(
                inflater, R.layout.fragment_title, container, false
        )
        binding.detailsButton.setOnClickListener{ view: View ->
            Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_detailsFragment)
        }
        binding.postButton.setOnClickListener{ view: View ->
            Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_postFragment)
        }
        return binding.root
    }
}