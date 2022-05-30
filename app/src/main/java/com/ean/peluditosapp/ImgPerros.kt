package com.ean.peluditosapp

import android.app.ProgressDialog
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ean.peluditosapp.databinding.ActivityImgPerrosBinding
import com.ean.peluditosapp.databinding.ActivityVerImagenBinding
import com.google.firebase.storage.FirebaseStorage
import java.io.File

class ImgPerros : AppCompatActivity() {

    lateinit var binding : ActivityImgPerrosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_img_perros
                binding = ActivityImgPerrosBinding.inflate(layoutInflater)
                setContentView(binding.root)

                binding.btObtenerimagenPerro.setOnClickListener {

            val progressdialog = ProgressDialog(this)
            progressdialog.setMessage("fetching image... ")
            progressdialog.setCancelable(false)
            progressdialog.show()

            val imagename = binding.etImageidPerro.text.toString()
            //localizar la imagen
            val storageref= FirebaseStorage.getInstance().reference.child("caninos/$imagename.png")
            //nombre tal cual de la imagen
            val localfile = File.createTempFile("tempimage,","png")



            storageref.getFile(localfile).addOnSuccessListener {

                if(progressdialog.isShowing){
                    progressdialog.dismiss()
                }

                val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
                binding.imageViewPerro.setImageBitmap(bitmap)

            }.addOnFailureListener {
                if(progressdialog.isShowing){
                    progressdialog.dismiss()
                }
                Toast.makeText(this,"ERROR", Toast.LENGTH_SHORT).show()
            }


        }

    }
    }
}