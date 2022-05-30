package com.ean.peluditosapp

import android.app.ProgressDialog
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.ean.peluditosapp.databinding.ActivityImgPerrosBinding

import com.ean.peluditosapp.databinding.ActivityVerImagenBinding
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import java.io.File

class ImgPerros : AppCompatActivity() {
    lateinit var binding1 :ActivityImgPerrosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_ver_imagen)
        binding1 = ActivityImgPerrosBinding.inflate(layoutInflater)
        setContentView(binding1.root)

        binding1.btnObtenerPerro.setOnClickListener {

            val progressdialog1 = ProgressDialog(this)
            progressdialog1.setMessage("fetching image... ")
            progressdialog1.setCancelable(false)
            progressdialog1.show()

            val imagename1 = binding1.etImageIdPerro.text.toString()
            //localizar la imagen
            val storageref1= FirebaseStorage.getInstance().reference.child("caninos/$imagename1.png")
            //nombre tal cual de la imagen
            val localfile1 = File.createTempFile("tempimage,","png")



            storageref1.getFile(localfile1).addOnSuccessListener {

                if(progressdialog1.isShowing){
                    progressdialog1.dismiss()
                }

                val bitmap = BitmapFactory.decodeFile(localfile1.absolutePath)
                binding1.imageViewPerro.setImageBitmap(bitmap)

            }.addOnFailureListener {
                if(progressdialog1.isShowing){
                    progressdialog1.dismiss()
                }
                Toast.makeText(this,"ERROR",Toast.LENGTH_SHORT).show()
            }


        }

    }
}