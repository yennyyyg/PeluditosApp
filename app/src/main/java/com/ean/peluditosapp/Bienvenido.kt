package com.ean.peluditosapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Bienvenido : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenido)
        val boton_adoptar=findViewById<Button>(R.id.bn_deseas_adop)
        boton_adoptar.setOnClickListener{
            val intent= Intent(this,Deseas_adoptar::class.java)
            startActivity(intent)
        }
    }
}