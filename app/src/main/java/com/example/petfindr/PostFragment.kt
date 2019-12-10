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
    var idd :Int= 1
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
//          myRef.setValue(petName)
//          myRef1.setValue(location)
//          myRef2.setValue(desc)


            val newid = getItemId()
            myRef.child("name").child(newid.toString()).setValue(petName)
            myRef.child("location").child(newid.toString()).setValue(location)
            myRef.child("Descritpion").child(newid.toString()).setValue(desc)



            Toast.makeText(context,"Posted!",Toast.LENGTH_SHORT).show()

            val myToast = Toast.makeText(context,"Posted!",Toast.LENGTH_SHORT)
            myToast.setGravity(Gravity.LEFT,200,200)
            myToast.setGravity(Gravity.RIGHT,200,200)
            myToast.show()
        }




        // Inflate the layout for this fragment

        return binding.root
    }

private fun getItemId():Int{

    idd ++
    return idd
}

    //make some dummy data
    data class Pet(
        val name: String = "",
        val description: String = "",
        val location: String = "",
        var uuid: String = "")


    fun loadDatabase(firebaseData: DatabaseReference) {
        val availableSalads: List<Pet> = mutableListOf(
            Pet("Gherkin", "Fresh and delicious","San Gabriel"),
            Pet("Lettuce", "Easy to prepare","Alhambra"),
            Pet("Tomato", "Boring but healthy","Los Angels"),
            Pet("Zucchini", "Healthy and gross","Temple City")
        )
        availableSalads.forEach {
            val key = firebaseData.child("pets").push().key
            it.uuid = key
            firebaseData.child("pets").child(key).setValue(it)
        }
    }
}


