package com.ean.peluditosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ean.peluditosapp.databinding.ActivityFormularioAdoptargatosBinding
import com.ean.peluditosapp.databinding.ActivityRegistrarUnpeluditoBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Formulario_adoptargatos : AppCompatActivity() {

    private lateinit var binding: ActivityFormularioAdoptargatosBinding
    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioAdoptargatosBinding.inflate(layoutInflater)


        setContentView(binding.root)
        binding.btFormulariogatos.setOnClickListener{

            val usuario_responsable = binding.txtUsernamegatos.text.toString()
            val cedula = binding.txtcedulagatos.text.toString()
            val ceuluar = binding.editTextPhonegatos.text.toString()
            val Direccion = binding.txtbarriogatos.text.toString()
            val mascotas = binding.textnumeromascotasgatos.text.toString()
            val ingresos = binding.txttrabajogatos.text.toString()
            val adopcion = binding.txtPorquedopciongatos.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Formulario para poder adoptar gatos ")
            val formulariogatos = formulariogatos(usuario_responsable,cedula,ceuluar,Direccion,mascotas,ingresos,adopcion)

            if(cedula.isEmpty() || usuario_responsable.isEmpty() || ceuluar.isEmpty()|| Direccion.isEmpty() || mascotas.isEmpty() ||ingresos.isEmpty() || adopcion.isEmpty()){

                Toast.makeText(this,"Ningun campo puede estar vacio, por fis, grax", Toast.LENGTH_SHORT).show()

            }else{

                database.child(usuario_responsable).setValue(formulariogatos).addOnSuccessListener {
                    binding.txtUsernamegatos.text.clear()
                    binding.txtcedulagatos.text.clear()
                    binding.editTextPhonegatos.text.clear()
                    binding.txtbarriogatos.text.clear()
                    binding.textnumeromascotasgatos.text.clear()
                    binding.txttrabajogatos.text.clear()
                    binding.txtPorquedopciongatos.text.clear()
                }

                Toast.makeText(this,"Se guardo correctamente", Toast.LENGTH_SHORT).show()

            }


        }
        }

    }
