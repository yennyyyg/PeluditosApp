package com.ean.peluditosapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.util.*


class Deseas_adoptar : AppCompatActivity() {
    // Create a storage reference from our app
    val storage = Firebase.storage
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deseas_adoptar)
        val storageRef=storage.reference
        val imagenes= ArrayList<String>()
        val imagenes2=ArrayList<String>()
        val listRef=storage.reference.child("caninos")
        val listFelinos=storage.reference.child("felinos")
        val listaImg=findViewById<ListView>(R.id.list_view_peluditos)
        // imagenes adoptar yenny

        val botonadoptar1 = findViewById<Button>(R.id.bt_adoptargatosyenny)
        botonadoptar1.setOnClickListener {
            val intent= Intent(this, Ver_imagen::class.java)
            startActivity(intent)
        }
        //Perros
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
//Gatos
        listFelinos.listAll()
            .addOnSuccessListener {
                for (i in it.items){
                    imagenes2.add(i.name+"")
                }
                Log.d("Firebase","files $imagenes2")
            }
            .addOnFailureListener{
                Log.d("Firebase","error $it")
            }
        val boton_Refre=findViewById<Button>(R.id.btn_refrescar)
        val boton_Perro=findViewById<CheckBox>(R.id.chb_perro)
        val boton_Gato=findViewById<CheckBox>(R.id.chb_gato)



        boton_Refre.setOnClickListener {
            listaImg.clearChoices()
            if (boton_Perro.isChecked && !boton_Gato.isChecked){

                val adapImg=ArrayAdapter(this,android.R.layout.simple_list_item_1,imagenes)
                listaImg.adapter=adapImg



            }else if (boton_Gato.isChecked && !boton_Perro.isChecked){
                val adapImgGato=ArrayAdapter(this,android.R.layout.simple_list_item_1,imagenes2)
                listaImg.adapter=adapImgGato
            }else if (boton_Perro.isChecked && boton_Gato.isChecked ){
                Toast.makeText(this,"Seleccione una sola opcion perro o gato, para cargar",Toast.LENGTH_SHORT).show()
                listaImg.adapter=null
            }else{
                Toast.makeText(this,"No ha seleccionado ninguna opción",Toast.LENGTH_SHORT).show()
                listaImg.adapter=null
            }

        }






    }


}
