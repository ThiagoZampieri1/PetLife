package com.example.petlife

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditLastVaccinationActivity : AppCompatActivity() {
    private lateinit var etUltimaVacinacao: EditText
    private lateinit var btnSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_last_vaccination_activity_main)

        etUltimaVacinacao = findViewById(R.id.et_ultima_vacinacao)
        btnSalvar = findViewById(R.id.btn_salvar)

        val ultimaVacinacao = intent.getStringExtra("ultima_vacinacao") ?: ""
        etUltimaVacinacao.setText(ultimaVacinacao)

        btnSalvar.setOnClickListener {
            val novaData = etUltimaVacinacao.text.toString()
            val resultIntent = Intent()
            resultIntent.putExtra("nova_data", novaData)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}
