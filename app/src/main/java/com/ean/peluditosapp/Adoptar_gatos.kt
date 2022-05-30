package com.ean.peluditosapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.ean.peluditosapp.databinding.ActivityAdoptarGatosBinding
import java.util.*

class Adoptar_gatos : AppCompatActivity() {
    private lateinit var  binding: ActivityAdoptarGatosBinding
    private lateinit var dataclassgatosArrayList :ArrayList<dataclass_gatos>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdoptarGatosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageid = intArrayOf(
            R.drawable.mia,R.drawable.macarena,
            R.drawable.mariposa,R.drawable.simon,
            R.drawable.pancho,R.drawable.pepe
        )

        val name = arrayOf(
            "Mia",
            "Macarena",
            "Mulan",
            "Simon",
            "Jerry",
            "Pancho"
        )

        val lastmessage = arrayOf(
            "Hola, Estoy buscando un hogar",
            "Busco una familia",
            "¡Adoptame!,Te amare por siempre,",
            "Soy el mejor compañero!",
            "¿Quieres ser mi kar@n, plisss?",
            "¡Adoptame!, Quiero una familia :("
        )

        val edad = arrayOf(
            "Tengo 6 meses",
            "Tengo 2 meses",
            "Tengo 3 años",
            "Tengo 5 años",
            "Tengo 9 meses",
            "Tengo 2 años",
        )

        val sexo = arrayOf(
            "Hembra",
            "Hembra",
            "Hembra",
            "Macho",
            "Macho",
            "Macho"
        )

        dataclassgatosArrayList = ArrayList()

        for(i in name.indices){
            val gatos = dataclass_gatos(name[i],edad[i],lastmessage[i],sexo[i],imageid[i])
            dataclassgatosArrayList.add(gatos)
        }

        binding.listxiew1.isClickable = true
        binding.listxiew1.adapter = Myadapter_gatos(this,dataclassgatosArrayList)
        binding.listxiew1.setOnItemClickListener{ parent,view,position,id ->

            val name = name[position]
            val sexo = sexo[position]
            val edad = edad[position]
            val imageid = imageid[position]
            val i = Intent(this,Animales_gatos_activity::class.java )

            i.putExtra("name",name)
            i.putExtra("sexo",sexo)
            i.putExtra("edad",edad)
            i.putExtra("imageid",imageid)
            startActivity(i)


        }




    }
}