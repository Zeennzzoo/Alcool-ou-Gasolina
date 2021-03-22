package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun calcularPreco(view : View){
        val precoAlcool = editPrecoAlcool.text.toString()
        val precoGasolina = editPrecoGasolina.text.toString()

        val validaCampos = validarCampos(precoAlcool, precoGasolina)
        if (validaCampos){
            calcularMelhorPreco(precoAlcool,precoGasolina)
        }else {
            textResultado.text = "Preencha os preços!"
        }

    }
    fun calcularMelhorPreco(precoGasolina: String, precoAlcool: String){
        val valorGasolina = precoGasolina.toDouble()
        val valorAlcool = precoAlcool.toDouble()

        val resultadoPreco = valorAlcool/valorGasolina

        if (resultadoPreco >= 0.7){
            textResultado.text = "Melhor utilizar gasolina!"
        }else{
            textResultado.text = "Melhor utilizar alcool!"
        }

    }

    fun validarCampos(precoAlcool : String, precoGasolina : String) : Boolean{

        var camposValidados : Boolean = true

        if (precoAlcool == null || precoAlcool == ("")){
            camposValidados = false
        }else if(precoGasolina == null || precoGasolina == ("")){
            camposValidados = false
        }
        return camposValidados
    }
}