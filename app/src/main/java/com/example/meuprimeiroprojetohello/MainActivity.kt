package com.example.meuprimeiroprojetohello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val edttxPeso: EditText = findViewById(R.id.edttext_peso)
        val edttxAltura: EditText = findViewById(R.id.edttext_altura)

        btnCalcular.setOnClickListener {

            //IMC

            val alturaStr = edttxAltura.text.toString()
            val pesoStr = edttxPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {

                val altura: Float = alturaStr.toFloat()
                val peso: Float = pesoStr.toFloat()

                val alturafinal: Float = altura * altura
                val result: Float = peso / alturafinal


                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Campo Obrigatório", Toast.LENGTH_LONG).show()
            }
        }
    }
}
// Recuperar UI component no arquivo Kotlin
 // ID do Componente
// Colocar ação em um botão