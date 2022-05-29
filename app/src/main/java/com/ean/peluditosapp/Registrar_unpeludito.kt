package com.ean.peluditosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ean.peluditosapp.databinding.ActivityRegistrarUnpeluditoBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class Registrar_unpeludito : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrarUnpeluditoBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarUnpeluditoBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_registrar_unpeludito)

        setContentView(binding.root)

        binding.btGuardarPeludo.setOnClickListener {
            val usuario_responsable = binding.txtUsername.text.toString()
            val celular = binding.editTextPhone.text.toString()
            val nombrepeludo = binding.textNombrePeludo.text.toString()
            val canino_felino = binding.textTipo.text.toString()
            val edad_peludo = binding.txtEdad.text.toString()
            val en_adopcion = binding.txtEnadopcion.text.toString()
            val enfermedad = binding.txtEnfermedad.text.toString()
            database = FirebaseDatabase.getInstance().getReference("Registrar peluditos para adoptar")
            val registrar_peludos = Registar_para_adoptar(usuario_responsable,celular,nombrepeludo,canino_felino,edad_peludo,en_adopcion,enfermedad)

            if(celular.isEmpty() || usuario_responsable.isEmpty() || nombrepeludo.isEmpty()|| canino_felino.isEmpty() || edad_peludo.isEmpty() || en_adopcion.isEmpty() || enfermedad.isEmpty()){

                Toast.makeText(this,"Ningun campo puede estar vacio, por fis, grax",Toast.LENGTH_SHORT).show()

            }else{

                database.child(usuario_responsable).setValue(registrar_peludos).addOnSuccessListener {
                    binding.txtUsername.text.clear()
                    binding.textNombrePeludo.text.clear()
                    binding.textTipo.text.clear()
                    binding.editTextPhone.text.clear()
                    binding.txtEdad.text.clear()
                    binding.txtEnadopcion.text.clear()
                    binding.txtEnfermedad.text.clear()
                }

                Toast.makeText(this,"Se guardo correctamente",Toast.LENGTH_SHORT).show()

            }


        }





    }
}