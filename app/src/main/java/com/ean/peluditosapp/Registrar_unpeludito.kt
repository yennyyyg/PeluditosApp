package com.ean.peluditosapp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.ean.peluditosapp.databinding.ActivityRegistrarUnpeluditoBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

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
            database = FirebaseDatabase.getInstance().getReference("users")
            val User = User(usuario_responsable,celular,nombrepeludo,canino_felino,edad_peludo,en_adopcion,enfermedad)

            if(celular.isEmpty() || usuario_responsable.isEmpty() || nombrepeludo.isEmpty()|| canino_felino.isEmpty() || edad_peludo.isEmpty() || en_adopcion.isEmpty() || enfermedad.isEmpty()){

                Toast.makeText(this,"Ningun campo puede estar vacio, por fis, grax",Toast.LENGTH_SHORT).show()

            }else{

                database.child(usuario_responsable).setValue(User).addOnSuccessListener {
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

               // .addOnFailureListener {

                   // Toast.makeText(this,"FAILED",Toast.LENGTH_SHORT).show()



            //}
        }





    }
}