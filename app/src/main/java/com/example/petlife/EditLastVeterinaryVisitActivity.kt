package com.example.petlife

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditLastVeterinaryVisitActivity : AppCompatActivity() {
    private lateinit var etUltimaIdaVeterinario: EditText
    private lateinit var btnSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.last_veterinary_visit_activity_main)

        etUltimaIdaVeterinario = findViewById(R.id.et_ultima_ida_veterinario)
        btnSalvar = findViewById(R.id.btn_salvar)
        val ultimaIda = intent.getStringExtra("ultima_ida_veterinario") ?: ""
        etUltimaIdaVeterinario.setText(ultimaIda)

        btnSalvar.setOnClickListener {
            val novaData = etUltimaIdaVeterinario.text.toString()
            val resultIntent = Intent()
            resultIntent.putExtra("nova_data", novaData)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}