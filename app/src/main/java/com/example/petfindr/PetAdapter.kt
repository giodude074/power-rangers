package com.example.petfindr

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

class PetAdapter(mCtx:Context, layoutResId:Int,petList: List<Pet>)

    : ArrayAdapter<Pet>(mCtx,layoutResId,petList){

     override getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx);
        val view:view=layoutInflater.inflate(layoutResId,null)



            }
}
