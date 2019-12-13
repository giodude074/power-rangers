package com.example.petfindr

import android.os.Bundle
import android.provider.ContactsContract
import android.renderscript.Sampler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.petfindr.databinding.FragmentMainBinding
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class MainFragment : Fragment() {
    lateinit var petList: MutableList<Pet>
    lateinit var ref:DatabaseReference
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
        val database = FirebaseDatabase.getInstance()
        petList= mutableListOf()

        val ref = database.getReference("Pets")



        val listView = binding.listviewPets



        // Inflate the layout for this fragment

        return binding.root
    }





}
