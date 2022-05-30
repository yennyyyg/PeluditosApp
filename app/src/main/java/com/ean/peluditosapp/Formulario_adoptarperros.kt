package com.ean.peluditosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ean.peluditosapp.databinding.ActivityFormularioAdoptargatosBinding
import com.ean.peluditosapp.databinding.ActivityFormularioAdoptarperrosBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Formulario_adoptarperros : AppCompatActivity() {
    private lateinit var binding: ActivityFormularioAdoptarperrosBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioAdoptarperrosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btFormularioperros.setOnClickListener{

            val usuario_responsable2 = binding.txtUsernameperros.text.toString()
            val cedula2 = binding.txtcedulaperros.text.toString()
            val ceuluar2 = binding.editTextPhoneperros.text.toString()
            val Direccion2 = binding.txtbarrioperros.text.toString()
            val mascotas2 = binding.textnumeromascotasperros.text.toString()
            val ingresos2 = binding.txttrabajoperros.text.toString()
            val adopcion2 = binding.txtPorquedopcionperros.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Formulario para poder adoptar gatos ")
            val formulariogatos = formulariogatos(usuario_responsable2,cedula2,ceuluar2,Direccion2,mascotas2,ingresos2,adopcion2)

            if(cedula2.isEmpty() || usuario_responsable2.isEmpty() || ceuluar2.isEmpty()|| Direccion2.isEmpty() || mascotas2.isEmpty()
                ||ingresos2.isEmpty() || adopcion2.isEmpty()){

                Toast.makeText(this,"Ningun campo puede estar vacio, por fis, grax", Toast.LENGTH_SHORT).show()

            }else{

                database.child(usuario_responsable2).setValue(formulariogatos).addOnSuccessListener {
                    binding.txtcedulaperros.text.clear()
                    binding.editTextPhoneperros.text.clear()
                    binding.txtbarrioperros.text.clear()
                    binding.textnumeromascotasperros.text.clear()
                    binding.txttrabajoperros.text.clear()
                    binding.txtPorquedopcionperros.text.clear()
                    binding.txtUsernameperros.text.clear()
                }

                Toast.makeText(this,"Se guardo correctamente", Toast.LENGTH_SHORT).show()

            }


        }

    }
}