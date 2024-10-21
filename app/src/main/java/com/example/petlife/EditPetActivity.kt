package com.example.petlife

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class EditPetActivity : AppCompatActivity() {

    private lateinit var etNome: EditText
    private lateinit var etDataNascimento: EditText
    private lateinit var spinnerTipo: Spinner
    private lateinit var etCor: EditText
    private lateinit var spinnerPorte: Spinner
    private lateinit var btnSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_pet_activity_main)

        etNome = findViewById(R.id.et_nome)
        etDataNascimento = findViewById(R.id.et_data_nascimento)
        spinnerTipo = findViewById(R.id.spinner_tipo)
        etCor = findViewById(R.id.et_cor)
        spinnerPorte = findViewById(R.id.spinner_porte)
        btnSalvar = findViewById(R.id.btn_salvar)


        val tipos = arrayOf("Cão", "Gato")
        val adapterTipo = ArrayAdapter(this, android.R.layout.simple_spinner_item, tipos)
        adapterTipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTipo.adapter = adapterTipo

        val portes = arrayOf("Pequeno", "Médio", "Grande")
        val adapterPorte = ArrayAdapter(this, android.R.layout.simple_spinner_item, portes)
        adapterPorte.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerPorte.adapter = adapterPorte

        btnSalvar.setOnClickListener {
            val intent = Intent()
            intent.putExtra("nome", etNome.text.toString())
            intent.putExtra("data_nascimento", etDataNascimento.text.toString())
            intent.putExtra("tipo", spinnerTipo.selectedItem.toString())
            intent.putExtra("cor", etCor.text.toString())
            intent.putExtra("porte", spinnerPorte.selectedItem.toString())

            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
