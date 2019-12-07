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
import com.google.firebase.database.FirebaseDatabase

class CreateFragment : Fragment() {

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


        val PostButton = binding.postButton

        PostButton.setOnClickListener {view: View->
            val PetName = binding.nameBox
            val Location = binding.locationBox
            val Descrtion = binding.locationBox





        }

        // Write a message to the database
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")










        return binding.root
    }








}
