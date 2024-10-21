package com.example.petlife

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditLastPetshopVisitActivity : AppCompatActivity() {
    private lateinit var etUltimaIdaPetshop: EditText
    private lateinit var btnSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_last_petshop_visit_main_activity)

        etUltimaIdaPetshop = findViewById(R.id.et_ultima_ida_petshop)
        btnSalvar = findViewById(R.id.btn_salvar)

        val ultimaIda = intent.getStringExtra("ultima_ida_petshop") ?: ""
        etUltimaIdaPetshop.setText(ultimaIda)

        btnSalvar.setOnClickListener {
            val novaData = etUltimaIdaPetshop.text.toString()
            val resultIntent = Intent()
            resultIntent.putExtra("nova_data", novaData)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}
