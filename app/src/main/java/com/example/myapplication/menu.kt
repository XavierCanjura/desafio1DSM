package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class menu : AppCompatActivity() {

    lateinit var lblUsuario : TextView
    lateinit var btnEjercicio1 : Button
    lateinit var btnEjercicio2 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        lblUsuario = findViewById(R.id.lblUsuario)
        btnEjercicio1 = findViewById(R.id.btnEjercicio1)
        btnEjercicio2 = findViewById(R.id.btnEjercicio2)

        this.getName()

        btnEjercicio1.setOnClickListener {
            val ejercicio1View = Intent(this, Ejercicio1::class.java)
            startActivity(ejercicio1View)
        }
    }

    private fun getName() {
        val credenciales = getSharedPreferences("credentials", Context.MODE_PRIVATE)
        val usuario = credenciales.getString("usuario", "Name")

        lblUsuario.setText("Bienvenido ${usuario}, selecciona un ejercicio")
        this.setTitle("Desafio 1 - ${usuario}")
    }
}