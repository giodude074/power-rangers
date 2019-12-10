package com.example.petfindr

import android.content.Context
import android.location.Location
import android.net.Uri
import android.os.Bundle
import android.util.EventLogTags
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import com.example.petfindr.databinding.FragmentPostBinding
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_post.*
import androidx.databinding.adapters.NumberPickerBindingAdapter.setValue
import com.google.firebase.database.DatabaseReference




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

            val database = FirebaseDatabase.getInstance()
            val petName = name_box.text.toString()
            val location = location_box.text.toString()
            val desc = description_box.text.toString()

            val myRef = database.getReference("name")
            val myRef1 = database.getReference("location")
            val myRef2 = database.getReference("Descritpion")
            myRef.setValue(petName)
            myRef1.setValue(location)
            myRef2.setValue(desc)

        }

        // Write a message to the database














        return binding.root
    }








}
