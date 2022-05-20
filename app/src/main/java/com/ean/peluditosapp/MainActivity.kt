package com.ean.peluditosapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Este boton me lleva a la actividad de Registrar un usuario
        val boton_registrar_usuario=findViewById<Button>(R.id.bn_ser_voluntario)
        boton_registrar_usuario.setOnClickListener {
            val intent= Intent(this,Registrarse::class.java)
            startActivity(intent)
        }

        //Este boton me lleva a la actividad de login
        val boton_login=findViewById<Button>(R.id.bn_deseas_adop)
        boton_login.setOnClickListener {
            val intent= Intent(this,Iniciar_Sesion::class.java)
            startActivity(intent)
        }

    }
}