package com.example.petlife

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditLastVeterinaryVisitActivity : AppCompatActivity() {
    private lateinit var etUltimaIdaVeterinario: EditText
    private lateinit var etSiteVeterinario: EditText
    private lateinit var etTelefoneVeterinario: EditText
    private lateinit var btnSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.last_veterinary_visit_activity_main)

        etUltimaIdaVeterinario = findViewById(R.id.et_ultima_ida_veterinario)
        etSiteVeterinario = findViewById(R.id.et_site_do_veterinario)
        etTelefoneVeterinario = findViewById(R.id.et_telefone_do_veterinario)
        btnSalvar = findViewById(R.id.btn_salvar)
        val ultimaIda = intent.getStringExtra("ultima_ida_veterinario") ?: ""
        val siteVet = intent.getStringExtra("site_veterinario") ?: ""
        val telefoneVet = intent.getStringExtra("telefone_veterinario")
        etUltimaIdaVeterinario.setText(ultimaIda)
        etSiteVeterinario.setText(siteVet)
        etTelefoneVeterinario.setText(telefoneVet)

        btnSalvar.setOnClickListener {
            val novaData = etUltimaIdaVeterinario.text.toString()
            val novoSite = etSiteVeterinario.text.toString()
            val novoTelefone = etTelefoneVeterinario.text.toString()
            val resultIntent = Intent()
            resultIntent.putExtra("nova_data", novaData)
            resultIntent.putExtra("novo_site", novoSite)
            resultIntent.putExtra("novo_telefone", novoTelefone)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}