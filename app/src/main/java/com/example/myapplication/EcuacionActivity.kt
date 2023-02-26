package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.sqrt

class EcuacionActivity : AppCompatActivity() {
    private lateinit var editTextA: EditText
    private lateinit var editTextB: EditText
    private lateinit var editTextC: EditText
    private lateinit var tvresultado: TextView
    private lateinit var btCalcular: Button

    // Instancia a Validations
    val validaciones = Validations()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecuacion)

        getName()

        editTextA = findViewById(R.id.editTextA)
        editTextB = findViewById(R.id.editTextB)
        editTextC = findViewById(R.id.editTextC)
        tvresultado = findViewById(R.id.tvresultado)
        btCalcular = findViewById(R.id.btCalcular)

        btCalcular.setOnClickListener{
            if(!validaciones.validateString(editTextA.text.toString()) || !validaciones.validateString(editTextB.text.toString()) || !validaciones.validateString(editTextC.text.toString()))
            {
                Toast.makeText(applicationContext, "No dejar campos vacios", Toast.LENGTH_SHORT).show()
            }
            else{
                val ecuacion =   editTextA.text.toString() +" "+  editTextB.text.toString() +" "+  editTextC.text.toString()
                val resultado = calcularResultado(ecuacion)
                tvresultado.text = resultado
            }

        }


    }

    private fun getName() {
        val credenciales = getSharedPreferences("credentials", Context.MODE_PRIVATE)
        val usuario = credenciales.getString("usuario", "Name")
        this.setTitle("Desafio 1 - ${usuario}")
    }

    private fun calcularResultado(ecuacion: String): String {
        val regex = Regex("[^0-9\\-]+")
        val numbers = regex.replace(ecuacion, " ").trim().split(" ").map { it.toDouble() }

        if (numbers.size != 3) {
            return "La ecuación debe ser de la siguinte forma ax^2 + bx + c = 0"
        }

        val a = numbers[0]
        val b = numbers[1]
        val c = numbers[2]

        val discriminant = b * b - 4 * a * c

        if (discriminant < 0) {
            return "Esta ecuación no tiene soluciones reales"
        }

        val x1 = (-b + sqrt(discriminant)) / (2 * a)
        val x2 = (-b - sqrt(discriminant)) / (2 * a)

        return "\nx1 = $x1, \n x2 = $x2"
    }
}

private fun View.setOnClickListener() {
    TODO("Not yet implemented")
}
