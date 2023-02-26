package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.sqrt

class EcuacionActivity : AppCompatActivity() {
    private lateinit var editTextA: EditText
    private lateinit var editTextB: EditText
    private lateinit var editTextC: EditText
    private lateinit var tvresultado: TextView
    private lateinit var btCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecuacion)

        editTextA = findViewById(R.id.editTextA)
        editTextB = findViewById(R.id.editTextB)
        editTextC = findViewById(R.id.editTextC)
        tvresultado = findViewById(R.id.tvresultado)
        btCalcular = findViewById(R.id.btCalcular)

        btCalcular.setOnClickListener{
            val ecuacion =   editTextA.text.toString() +" "+  editTextB.text.toString() +" "+  editTextC.text.toString()
            val resultado = calcularResultado(ecuacion)
            tvresultado.text = resultado
        }
    }



    private fun calcularResultado(ecuacion: String): String {
        val regex = Regex("[^0-9\\-]+")
        val numbers = regex.replace(ecuacion, " ").trim().split(" ").map { it.toDouble() }

        if (numbers.size != 3) {
            return "La ecuación debe ser de la forma ax^2 + bx + c = 0"
        }

        val a = numbers[0]
        val b = numbers[1]
        val c = numbers[2]

        val discriminant = b * b - 4 * a * c

        if (discriminant < 0) {
            return "La ecuación no tiene soluciones reales"
        }

        val x1 = (-b + sqrt(discriminant)) / (2 * a)
        val x2 = (-b - sqrt(discriminant)) / (2 * a)

        return "\nx1 = $x1, \n x2 = $x2"
    }
}

private fun View.setOnClickListener() {
    TODO("Not yet implemented")
}