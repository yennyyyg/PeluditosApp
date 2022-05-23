package com.ean.peluditosapp

import android.annotation.SuppressLint
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
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deseas_adoptar)
        val imagenesperro=ArrayList<String>()
        val imagenesgato=ArrayList<String>()
        val listRef=storage.reference.child("caninos")
        val listFelinos=storage.reference.child("felinos")
        val listaImg=findViewById<ListView>(R.id.list_view_peluditos)
        val boton_Perro=findViewById<RadioButton>(R.id.chb_perro)
        boton_Perro.setOnClickListener {
            listRef.listAll()
                .addOnSuccessListener {
                    for (i in it.items){
                        imagenesperro.add(i.name+"")
                    }
                    Log.d("Firebase","files $imagenesperro")
                }
                .addOnFailureListener{
                    Log.d("Firebase","error $it")
                }

            val adapImg=ArrayAdapter(this,android.R.layout.simple_list_item_1,imagenesperro)
            listaImg.adapter=adapImg
        }

        val boton_Gato=findViewById<RadioButton>(R.id.chb_gato)
        boton_Gato.setOnClickListener {
            listFelinos.listAll()
                .addOnSuccessListener {
                    for (i in it.items){
                        imagenesgato.add(i.name+"")
                    }
                    Log.d("Firebase","files $imagenesgato")
                }
                .addOnFailureListener{
                    Log.d("Firebase","error $it")
                }

            val adapImg=ArrayAdapter(this,android.R.layout.simple_list_item_1,imagenesgato)
            listaImg.adapter=adapImg
        }

    }


}
