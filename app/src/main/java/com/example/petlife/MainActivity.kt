package com.example.petlife

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.petlife.ui.Pet

class MainActivity : AppCompatActivity() {
    private lateinit var tvNome: TextView
    private lateinit var tvDataNascimento: TextView
    private lateinit var tvTipo: TextView
    private lateinit var tvCor: TextView
    private lateinit var tvPorte: TextView
    private lateinit var tvUltimaIdaVeterinario: TextView
    private lateinit var tvUltimaIdaPetshop: TextView
    private lateinit var tvUltimaVacinacao: TextView
    private lateinit var tvSiteVeterinario: TextView
    private lateinit var tvTelefoneVeterinario: TextView

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
        tvSiteVeterinario = findViewById(R.id.tv_site_veterinario)

        tvTelefoneVeterinario = findViewById(R.id.tv_telefone_veterinario)

        pet = Pet(
            nome = "Cher",
            dataNascimento = "01/01/2020",
            tipo = "Cão",
            cor = "Marrom",
            porte = "Grande",
            ultimaIdaVeterinario = "15/08/2023",
            ultimaIdaPetshop = "10/09/2023",
            ultimaVacinacao = "20/07/2023",
            siteVeterinario = "https://google.com.br",
            telefoneVeterinario = "5516997175632"
        )

        updatePetInfo()

        findViewById<Button>(R.id.btn_alterar_dados_pet).setOnClickListener {
            val intent = Intent(this, EditPetActivity::class.java)
            intent.putExtra("nome", pet.nome)
            intent.putExtra("data_nascimento", pet.dataNascimento)
            intent.putExtra("tipo", pet.tipo)
            intent.putExtra("cor", pet.cor)
            intent.putExtra("porte", pet.porte)
            startActivityForResult(intent, REQUEST_CODE_EDIT_PET)
        }

        findViewById<Button>(R.id.btn_alterar_dados_veterinario).setOnClickListener {
            val intent = Intent(this, EditLastVeterinaryVisitActivity::class.java)
            intent.putExtra("ultima_ida_veterinario", pet.ultimaIdaVeterinario)
            intent.putExtra("site_veterinario", pet.siteVeterinario)
            intent.putExtra("telefone_veterinario", pet.telefoneVeterinario)

            startActivityForResult(intent, REQUEST_CODE_EDIT_VETERINARY_VISIT)
        }

        findViewById<Button>(R.id.btn_alterar_dados_vacinacao).setOnClickListener {
            val intent = Intent(this, EditLastVaccinationActivity::class.java)
            intent.putExtra("ultima_vacinacao", pet.ultimaVacinacao)
            startActivityForResult(intent, REQUEST_CODE_EDIT_VACCINATION)
        }

        findViewById<Button>(R.id.btn_alterar_dados_petshop).setOnClickListener {
            val intent = Intent(this, EditLastPetshopVisitActivity::class.java)
            intent.putExtra("ultima_ida_petshop", pet.ultimaIdaPetshop)
            startActivityForResult(intent, REQUEST_CODE_EDIT_PETSHOP_VISIT)
        }

        findViewById<Button>(R.id.btn_ligar_veterinario).setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${pet.telefoneVeterinario}")
            startActivityForResult(intent, REQUEST_CODE_PHONE_CALL)
        }

        findViewById<Button>(R.id.btn_site_veterinario).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(pet.siteVeterinario))
            startActivityForResult(intent, REQUEST_CODE_SITE_CALL)
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
        tvSiteVeterinario.text = "Site do veterinário: ${pet.siteVeterinario}"
        tvTelefoneVeterinario.text = "Telefone do veterinário: ${pet.telefoneVeterinario}"
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_EDIT_PET && resultCode == RESULT_OK) {
            pet.nome = data?.getStringExtra("nome") ?: pet.nome
            pet.dataNascimento = data?.getStringExtra("data_nascimento") ?: pet.dataNascimento
            pet.tipo = data?.getStringExtra("tipo") ?: pet.tipo
            pet.cor = data?.getStringExtra("cor") ?: pet.cor
            pet.porte = data?.getStringExtra("porte") ?: pet.porte

            updatePetInfo()
        } else if (requestCode == REQUEST_CODE_EDIT_VETERINARY_VISIT && resultCode == RESULT_OK) {
            pet.ultimaIdaVeterinario = data?.getStringExtra("nova_data") ?: pet.ultimaIdaVeterinario
            pet.siteVeterinario = data?.getStringExtra("novo_site") ?: pet.siteVeterinario
            pet.telefoneVeterinario = data?.getStringExtra("novo_telefone") ?: pet.telefoneVeterinario
            updatePetInfo()
        } else if (requestCode == REQUEST_CODE_EDIT_VACCINATION && resultCode == RESULT_OK) {
            pet.ultimaVacinacao = data?.getStringExtra("nova_data") ?: pet.ultimaVacinacao
            updatePetInfo()
        } else if (requestCode == REQUEST_CODE_EDIT_PETSHOP_VISIT && resultCode == RESULT_OK) {
            pet.ultimaIdaPetshop = data?.getStringExtra("nova_data") ?: pet.ultimaIdaPetshop
            updatePetInfo()
        }
    }

    companion object {
        const val REQUEST_CODE_EDIT_PET = 1
        const val REQUEST_CODE_EDIT_VETERINARY_VISIT = 2
        const val REQUEST_CODE_EDIT_VACCINATION = 3
        const val REQUEST_CODE_EDIT_PETSHOP_VISIT = 4
        const val REQUEST_CODE_PHONE_CALL = 5
        const val REQUEST_CODE_SITE_CALL = 6
    }
}
