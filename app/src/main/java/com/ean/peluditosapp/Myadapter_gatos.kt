package com.ean.peluditosapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class Myadapter_gatos(private val context : Activity,private val arrayList: ArrayList<dataclass_gatos>):ArrayAdapter<dataclass_gatos>
    (context,R.layout.list_item11) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


        val inflater:LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.list_item11,null)

        val imageView : ImageView = view.findViewById(R.id.profile_pic)
        val username : TextView = view.findViewById(R.id.catname)
        val mensaje : TextView = view.findViewById(R.id.mensajegatos)
        val edad : TextView = view.findViewById(R.id.edadgatos)
        val sexo : TextView = view.findViewById(R.id.sexogatos)


        imageView.setImageResource(arrayList[position].imageid)
        username.text = arrayList[position].name
        mensaje.text = arrayList[position].mensaje
        edad.text = arrayList[position].edad
        sexo.text =arrayList[position].sexo



        return view
    }


}