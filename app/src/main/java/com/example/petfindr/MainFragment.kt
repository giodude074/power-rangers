package com.example.petfindr

import RecyclerViewAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petfindr.databinding.FragmentMainBinding
import java.util.ArrayList


class MainFragment : Fragment() {

    private val TAG = "MainFragment"

    //vars
    private val mNames = ArrayList<String>()
    private val mImageUrls = ArrayList<String>()


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

        initImageBitmaps(binding) //loads into arraylist

        // Inflate the layout for this fragment

        return binding.root
    }

    private fun initImageBitmaps(binding: FragmentMainBinding) {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.")

        mImageUrls.add("https://i.redd.it/5swrmebtq1n31.jpg")
        mNames.add("Pixie | Description: white pomeranian, missing a back leg | Location: Beverly Hills")

        mImageUrls.add("https://i.imgur.com/PMlW8iJ.png")
        mNames.add("Demon | Description: Hairless cat, sweet personality | Location: New York")

        mImageUrls.add("https://i.redd.it/i7kkhi48bwz01.jpg")
        mNames.add("Pookie | Description: Brown and white bulldog, Shy | Location: Mississipi")

        mImageUrls.add("https://i.redd.it/1foqpktuwr211.jpg")
        mNames.add("Baxter | Description: Good Boy | Location: Mississippi")

        initRecyclerView(binding)
    }

    //setting up our recycle view
    private fun initRecyclerView(binding: FragmentMainBinding) {
        Log.d(TAG, "initRecyclerView: init recyclerview.")
        val recyclerView: RecyclerView = binding.root.findViewById(R.id.recyclerv_view)




        val adapter: RecyclerViewAdapter = RecyclerViewAdapter(this.requireContext(), mNames, mImageUrls)
        recyclerView. setAdapter(adapter)
        recyclerView.setLayoutManager(LinearLayoutManager(this.requireContext()))
    }



}
