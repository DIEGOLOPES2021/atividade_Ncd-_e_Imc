package br.senai.sp.jandira.imcapp20

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class NcdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ncd)

        val btnCalcular: Button = findViewById(R.id.butoon_calcular_ncd)

        val edPeso: EditText = findViewById(R.id.ed_peso)
        val spinnerAtividade: Spinner = findViewById(R.id.spinner_atividade)
        val spinnerIdade: Spinner = findViewById(R.id.spinner_idade)

        val radioFeminino: RadioButton = findViewById(R.id.rbutoon_feminino)


        btnCalcular.setOnClickListener {
            if (edPeso.text.isEmpty()){
                edPeso.error = "Este campo é nescessário"

            }

            if (edPeso.text.isNotEmpty()){
                val peso: Double = edPeso.text.toString().toDouble()
                val nivelAtividade = spinnerAtividade.selectedItemPosition

                val faixaEtaria = spinnerIdade.selectedItemPosition

                val intent = Intent(this, ResultadoNcdActivity::class.java)
                

                if (radioFeminino.isChecked()){
                    val genero = 'f'
                    intent.putExtra("genero", genero)
                }else{
                    val genero = 'm'
                    intent.putExtra("genero", genero)
                }
                intent.putExtra("peso", peso)
                intent.putExtra("nivelAtividade", nivelAtividade)
                intent.putExtra("faixaIdade", faixaEtaria)
                startActivity(intent)
            }
        }
    }
}