package com.ean.peluditosapp

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast

import com.ean.peluditosapp.databinding.ActivityVerImagenBinding
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import java.io.File

class Ver_imagen : AppCompatActivity() {
    lateinit var binding :ActivityVerImagenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_ver_imagen)
        binding = ActivityVerImagenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var adoptargg = findViewById<Button>(R.id.bt_adoptargatos)
        adoptargg.setOnClickListener {
            val intent= Intent(this,Formulario_adoptargatos::class.java)
            startActivity(intent)
        }

        binding.btObtenerimagen.setOnClickListener {

            val progressdialog = ProgressDialog(this)
            progressdialog.setMessage("fetching image... ")
            progressdialog.setCancelable(false)
            progressdialog.show()

            val imagename = binding.etImageid.text.toString()
            //localizar la imagen
            val storageref= FirebaseStorage.getInstance().reference.child("mascotas/$imagename.jfif")
            //nombre tal cual de la imagen
            val localfile = File.createTempFile("tempimage,","jfif")



            storageref.getFile(localfile).addOnSuccessListener {

                if(progressdialog.isShowing){
                    progressdialog.dismiss()
                }

                val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
                binding.imageView.setImageBitmap(bitmap)

            }.addOnFailureListener {
                if(progressdialog.isShowing){
                    progressdialog.dismiss()
                }
                Toast.makeText(this,"ERROR",Toast.LENGTH_SHORT).show()
            }


        }

    }
}