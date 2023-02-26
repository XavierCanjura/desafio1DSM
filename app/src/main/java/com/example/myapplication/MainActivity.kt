package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

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
            this.guardardatos()
        }
    }

    private fun guardardatos(){
        val credenciales = getSharedPreferences("credentials", Context.MODE_PRIVATE)
        var editor = credenciales.edit()
        editor.putString("usuario", usuario.text.toString())
        editor.commit()

        val Menu = Intent(this, menu::class.java)
        startActivity(Menu)
    }
}