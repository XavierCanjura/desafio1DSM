package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var usuario: EditText
    lateinit var password: EditText
    lateinit var ingresar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usuario = findViewById(R.id.txtUsuario)
        password = findViewById(R.id.txtPassword)
        ingresar = findViewById(R.id.btnIniciar)

        ingresar.setOnClickListener {
            if(usuario.text.toString() == "" || password.text.toString() == "")
            {
                Toast.makeText(applicationContext, "Ingrese sus credenciales", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            this.guardarDatos()
        }
    }

    private fun guardarDatos(){
        val credenciales = getSharedPreferences("credentials", Context.MODE_PRIVATE)
        var editor = credenciales.edit()
        editor.putString("usuario", usuario.text.toString())
        editor.commit()

        val Menu = Intent(this, menu::class.java)
        startActivity(Menu)
    }
}