package com.example.petfindr

import RecyclerViewAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.petfindr.databinding.ActivityMainBinding
import androidx.recyclerview.widget.RecyclerView
import android.util.Log;
import androidx.recyclerview.widget.LinearLayoutManager
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    //vars
    private val mNames = ArrayList<String>()
    private val mImageUrls = ArrayList<String>()


    private lateinit var drawerLayout: DrawerLayout
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



        initImageBitmaps() //loads into arraylist
    } //oncreate END

    //override this method to tell Android to call navigateUp() in the navigation controller when
    //up button is pressed
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

    //RECYCLEVIEW STUFF
    private fun initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.")

        mImageUrls.add("https://i.redd.it/5swrmebtq1n31.jpg")
        mNames.add("Pixie | Description: white pomeranian, missing a back leg | Location: Beverly Hills")

        mImageUrls.add("https://i.imgur.com/PMlW8iJ.png")
        mNames.add("Demon | Description: Hairless cat, sweet personality | Location: New York")

        mImageUrls.add("https://i.redd.it/i7kkhi48bwz01.jpg")
        mNames.add("Pookie | Description: Brown and white bulldog, Shy | Location: Mississippi")

        mImageUrls.add("https://i.redd.it/1foqpktuwr211.jpg")
        mNames.add("Baxter | Description: Good Boy | Location: Mississippi")

        initRecyclerView()
    }

    //setting up our recycle view
    private fun initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview.")
        val recyclerView: RecyclerView = findViewById(R.id.recyclerv_view)

        val adapter = RecyclerViewAdapter(this, mNames, mImageUrls)
        recyclerView. setAdapter(adapter)
        recyclerView.setLayoutManager(LinearLayoutManager(this))
    }
}
