package com.ean.peluditosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ean.peluditosapp.databinding.ActivityAdoptarGatosBinding
import com.ean.peluditosapp.databinding.ActivityAnimalesGatosBinding

class Animales_gatos_activity : AppCompatActivity() {
    private lateinit var  binding: ActivityAnimalesGatosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalesGatosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name=intent.getStringExtra("name")
        val edad=intent.getStringExtra("edad")
        val sexo=intent.getStringExtra("sexo")
        val imageId=intent.getIntExtra("imageId",R.id.profile_pic)
        binding.profilepicGatos.setImageResource(imageId)
        binding.Nombregatos.text=name
        binding.edadgatos1.text=edad
        binding.sexogg.text=sexo

        
    }
}