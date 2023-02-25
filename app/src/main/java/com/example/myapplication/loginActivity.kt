package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class loginActivity : AppCompatActivity() {

    lateinit var usuario:EditText
    lateinit var password:EditText
    lateinit var ingresar:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usuario = findViewById(R.id.txtUsuario)
        password = findViewById(R.id.txtPassword)
        ingresar = findViewById(R.id.btnIniciar)
    }

    private fun guardarDatos(){

    }
}