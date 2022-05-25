package com.ean.peluditosapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.ean.peluditosapp.databinding.ActivityAportarBinding

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class Aportar : AppCompatActivity() {
    private lateinit var binding: ActivityAportarBinding
    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAportarBinding.inflate(layoutInflater)
       // setContentView(R.layout.activity_aportar)

        setContentView(binding.root)
        binding.btAportaraportar.setOnClickListener {
            val usuario = binding.txNombreaporytar.text.toString()
            val ceudla = binding.txtCedilaaporytar.text.toString()
            val celular1 = binding.txtCelularaportar.text.toString()
            val dinero  = binding.txtDineroaportar.text.toString()
            val otros = binding.txtOtrosaportar.text.toString()
            database = FirebaseDatabase.getInstance().getReference("Recolecciones_pagos")
            val Recolecciones_pagos = Recolecciones_pagos(usuario,ceudla,celular1,dinero,otros)

            if(usuario.isEmpty() ||ceudla.isEmpty() || celular1.isEmpty()|| dinero.isEmpty() || otros.isEmpty()){

                Toast.makeText(this,"Ningun campo puede estar vacio, por fis, grax", Toast.LENGTH_SHORT).show()

            }else{

                database.child(usuario).setValue(Recolecciones_pagos).addOnSuccessListener {
                    binding.txNombreaporytar.text.clear()
                    binding.txtCedilaaporytar.text.clear()
                    binding.txtCelularaportar.text.clear()
                    binding.txtDineroaportar.text.clear()
                    binding.txtOtrosaportar.text.clear()

                }

                Toast.makeText(this,"MUCHAS GRACIAS POR TU AYUDA!!!, ESTAMOS AGRADECIDOSSSSS", Toast.LENGTH_SHORT).show()

            }

        }
        val boton_REGRESAR1=findViewById<Button>(R.id.bt_atrasaportar)
        boton_REGRESAR1.setOnClickListener {
            val intent= Intent(this,Bienvenido::class.java)
            startActivity(intent)
        }


    }
}