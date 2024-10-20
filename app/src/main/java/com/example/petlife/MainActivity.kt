package com.example.petlife

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.petlife.ui.Pet

class MainActivity: AppCompatActivity() {
    private lateinit var tvNome: TextView
    private lateinit var tvDataNascimento: TextView
    private lateinit var tvTipo: TextView
    private lateinit var tvCor: TextView
    private lateinit var tvPorte: TextView
    private lateinit var tvUltimaIdaVeterinario: TextView
    private lateinit var tvUltimaIdaPetshop: TextView
    private lateinit var tvUltimaVacinacao: TextView

    private lateinit var pet: Pet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvNome = findViewById(R.id.tv_nome)
        tvDataNascimento = findViewById(R.id.tv_data_nascimento)
        tvTipo = findViewById(R.id.tv_tipo)
        tvCor = findViewById(R.id.tv_cor)
        tvPorte = findViewById(R.id.tv_porte)
        tvUltimaIdaVeterinario = findViewById(R.id.tv_ultima_ida_veterinario)
        tvUltimaIdaPetshop = findViewById(R.id.tv_ultima_ida_petshop)
        tvUltimaVacinacao = findViewById(R.id.tv_ultima_vacinacao)

        pet = Pet(
            nome = "Cher",
            dataNascimento = "01/01/2020",
            tipo = "Cão",
            cor = "Marrom",
            porte = "Grande",
            ultimaIdaVeterinario = "15/08/2023",
            ultimaIdaPetshop = "10/09/2023",
            ultimaVacinacao = "20/07/2023"
        )

        updatePetInfo()

        findViewById<Button>(R.id.btn_alterar_dados_pet).setOnClickListener {
        }

    }

    private fun updatePetInfo() {
        tvNome.text = "Nome: ${pet.nome}"
        tvDataNascimento.text = "Data de Nascimento: ${pet.dataNascimento}"
        tvTipo.text = "Tipo: ${pet.tipo}"
        tvCor.text = "Cor: ${pet.cor}"
        tvPorte.text = "Porte: ${pet.porte}"
        tvUltimaIdaVeterinario.text = "Última ida ao veterinário: ${pet.ultimaIdaVeterinario}"
        tvUltimaIdaPetshop.text = "Última ida ao petshop: ${pet.ultimaIdaPetshop}"
        tvUltimaVacinacao.text = "Última vacinação: ${pet.ultimaVacinacao}"
    }
}