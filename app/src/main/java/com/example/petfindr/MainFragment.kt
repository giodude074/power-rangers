package com.example.petfindr

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.petfindr.databinding.FragmentMainBinding
import java.util.ArrayList
import RecyclerViewAdapter
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.firebase.database.FirebaseDatabase



class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMainBinding>(
            inflater,
            R.layout.fragment_main,
            container,
            false
        )









        // Inflate the layout for this fragment

        return binding.root
    }





}
