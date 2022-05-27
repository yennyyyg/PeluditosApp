package com.ean.peluditosapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Este boton me lleva a la actividad de Registrar un usuario
        val boton_registrar_usuario=findViewById<Button>(R.id.bn_registrarpeludito)
        boton_registrar_usuario.setOnClickListener {
            val intent= Intent(this,Registrarse::class.java)
            startActivity(intent)
        }
        val boton_login=findViewById<Button>(R.id.bn_deseas_adop)
        boton_login.setOnClickListener {
            val intent= Intent(this,Iniciar_Sesion::class.java)
            startActivity(intent)
        }
        //Este boton me lleva a la actividad de login


        val boton_cerrar_sesion=findViewById<Button>(R.id.bn_cerrar_sesion_am)
        boton_cerrar_sesion.setOnClickListener {
            auth.signOut()//cierra sesion
            if(auth.currentUser==null){
                boton_cerrar_sesion.visibility= View.INVISIBLE
                boton_login.visibility=View.VISIBLE
                boton_registrar_usuario.visibility=View.VISIBLE
            }
        }


    }
}