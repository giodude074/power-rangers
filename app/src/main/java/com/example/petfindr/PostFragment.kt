package com.example.petfindr

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.petfindr.databinding.FragmentPostBinding
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.fragment_post.*
import com.google.firebase.database.FirebaseDatabase
import android.view.Gravity

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


        val postButton = binding.postButton

        postButton.setOnClickListener {view: View->


            val database = FirebaseDatabase.getInstance()
            val petName = name_box.text.toString().trim()
            val location = location_box.text.toString().trim()
            val desc = description_box.text.toString().trim()

            val myRef = database.getReference("Pets")
            val uuid = myRef.push().key.toString().trim()



            myRef.child(uuid).child("Name").setValue((petName))
            myRef.child(uuid).child("Location").setValue((location))
            myRef.child(uuid).child("Description").setValue((desc))



            Toast.makeText(context,"Posted!",Toast.LENGTH_SHORT).show()

            val myToast = Toast.makeText(context,"Posted!",Toast.LENGTH_SHORT)
            myToast.setGravity(Gravity.LEFT,200,200)
            myToast.setGravity(Gravity.RIGHT,200,200)
            myToast.show()
        }




        // Inflate the layout for this fragment

        return binding.root

    }
}









