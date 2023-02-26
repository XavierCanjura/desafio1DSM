package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener

class Ejercicio1 : AppCompatActivity() {

    var meses = arrayOf("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre")

    lateinit var txtNombre: EditText
    lateinit var txtCodigo: EditText
    lateinit var txtVentas: EditText
    lateinit var cmbMeses: Spinner
    lateinit var btnCalcular: Button

    var ventas: Int = 0
    var nombre: String = ""
    var mesVenta: String = ""
    var codigo: String = ""

    data class Result(val comision: Int, val porcentaje: Int)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)

        txtNombre = findViewById(R.id.txtNombre)
        txtCodigo = findViewById(R.id.txtCodigo)
        txtVentas = findViewById(R.id.txtVentas)
        cmbMeses = findViewById(R.id.cmbMeses)
        btnCalcular = findViewById(R.id.btnCalcular)

        this.getName()
        this.setOptions()

        // Es un escuchador y se ejecuta cada vez que selecciona una opcion del Spinner
        cmbMeses.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                mesVenta = meses[position]
            }
        }

        btnCalcular.setOnClickListener {
            this.getInformacion()
            var ( comision, porcentaje ) = this.calcularComision(ventas)

            var resultView = Intent(this, ResultEjercicio1::class.java).apply {
                putExtra("nombre", nombre)
                putExtra("codigo", codigo)
                putExtra("ventas", ventas)
                putExtra("comision", comision)
                putExtra("porcentaje", porcentaje)
                putExtra("mes", mesVenta)
            }

            startActivity(resultView)
        }

    }

    private fun getName() {
        val credenciales = getSharedPreferences("credentials", Context.MODE_PRIVATE)
        val usuario = credenciales.getString("usuario", "Name")
        this.setTitle("Desafio 1 - ${usuario}")
    }

    /* Funcion para setear las opciones en el Spinner */
    private fun setOptions(){
        var options = ArrayAdapter(this, android.R.layout.simple_spinner_item, meses)
        options.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        cmbMeses.adapter = options
        cmbMeses.prompt = "Selecciona un mes"
        cmbMeses.setSelection(0, false)
        cmbMeses.gravity = Gravity.CENTER
    }

    // Funcion para obtener los datos del formulario
    private fun getInformacion(){
        nombre = txtNombre.text.toString()
        codigo = txtCodigo.text.toString()
        ventas = txtVentas.text.toString().toInt()
    }


    // Funcion para calcular la comision del vendedor
    private fun calcularComision(ventas: Int): Result {
        var comision: Int = 0
        var porcentaje: Int = 0

        when{
            ventas < 500 -> {
                comision = 0
                porcentaje = 0
            }
            ventas in 500..999 -> {
                comision = (ventas * 0.05).toInt()
                porcentaje = 5
            }
            ventas in 1000..1999 -> {
                comision = (ventas * 0.1).toInt()
                porcentaje = 10
            }
            ventas in 2000..2999 -> {
                comision = (ventas * 0.15).toInt()
                porcentaje = 15
            }
            ventas in 3000..3999 -> {
                comision = (ventas * 0.20).toInt()
                porcentaje = 20
            }
            ventas >= 4000 -> {
                comision = (ventas * 0.30).toInt()
                porcentaje = 30
            }
        }

        return Result(comision, porcentaje)
    }

}
