package com.example.petfindr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.petfindr.databinding.ActivityMainBinding
import com.google.firebase.database.*


class MainActivity : AppCompatActivity() {

    lateinit var ref: DatabaseReference

    private lateinit var drawerLayout: DrawerLayout

    lateinit var petList:MutableList<Pet>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        drawerLayout = binding.drawerLayout

        //getting a navController object
        val navController = this.findNavController(R.id.nav_host_fragment)

        //links navigation controller to the app bar
        NavigationUI.setupActionBarWithNavController(this,navController)
        NavigationUI.setupWithNavController(binding.navView, navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("Pets")
        petList= mutableListOf()


        ref.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0!!.exists()){
                    for (h in p0.children){
                        val pet = h.getValue(Pet::class.java)
                        petList.add(pet!!)

                    }


                }


            }


        })


















    }

    //oncreate END

    //override this method to tell Android to call navigateUp() in the navigation controller when
    //up button is pressed
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }


}
