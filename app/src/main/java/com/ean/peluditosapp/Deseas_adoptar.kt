package com.ean.peluditosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.RadioButton
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage


class Deseas_adoptar : AppCompatActivity() {
    // Create a storage reference from our app
    val storage = Firebase.storage
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deseas_adoptar)
        val storageRef=storage.reference
        val imagenes=ArrayList<String>()
        val listRef=storage.reference.child("caninos")
        val listFelinos=storage.reference.child("felinos")
        listRef.listAll()
            .addOnSuccessListener {
                for (i in it.items){
                    imagenes.add(i.name+"")
                }
                Log.d("Firebase","files $imagenes")
            }
            .addOnFailureListener{
                Log.d("Firebase","error $it")
            }
        val boton_Refre=findViewById<Button>(R.id.btn_refrescar)
        boton_Refre.setOnClickListener {
            val listaImg=findViewById<ListView>(R.id.list_view_peluditos)
            val adapImg=ArrayAdapter(this,android.R.layout.simple_list_item_1,imagenes)
            listaImg.adapter=adapImg
        }

    }


}
