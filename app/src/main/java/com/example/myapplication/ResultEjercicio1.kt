package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ResultEjercicio1 : AppCompatActivity() {
    lateinit var lblResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_ejercicio1)

        val nombre = intent.getStringExtra("nombre")
        val codigo = intent.getStringExtra("codigo")
        val venta = intent.getIntExtra("ventas", 0)
        val comision = intent.getIntExtra("comision",0)
        val porcentaje = intent.getIntExtra("porcentaje",0)
        val mes = intent.getStringExtra("mes")

        lblResult = findViewById(R.id.lblResult)
        this.getName()

        lblResult.setText("El empleado ${nombre} con codigo ${codigo}, el mes de ${mes} vendió $${venta} en productos " +
                "por la cantidad que vendió obtuvo ${porcentaje}% de comision sobre las ventas. La comision total a recibir es de $${comision}.")
    }

    private fun getName() {
        val credenciales = getSharedPreferences("credentials", Context.MODE_PRIVATE)
        val usuario = credenciales.getString("usuario", "Name")
        this.setTitle("Desafio 1 - ${usuario}")
    }
}