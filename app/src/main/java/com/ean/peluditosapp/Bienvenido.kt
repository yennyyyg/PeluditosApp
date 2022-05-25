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
        val boton_registrar_peludito=findViewById<Button>(R.id.bn_registrarpeludito)
        boton_registrar_peludito.setOnClickListener {
            val intent= Intent(this,Registrar_unpeludito::class.java)
            startActivity(intent)
        }
        val boton_aportar=findViewById<Button>(R.id.bt_aportar)
        boton_aportar.setOnClickListener {
            val intent= Intent(this,Aportar::class.java)
            startActivity(intent)
        }
        val boton_REGRESAR=findViewById<Button>(R.id.bt_regresar)
        boton_REGRESAR.setOnClickListener {
            val intent= Intent(this,Iniciar_Sesion::class.java)
            startActivity(intent)
        }

    }
}