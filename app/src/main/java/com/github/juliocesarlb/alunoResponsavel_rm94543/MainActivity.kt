package com.github.juliocesarlb.alunoResponsavel_rm94543

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.RecyclerView
import com.github.juliocesarlb.alunoResponsavel_rm94543.adapter.ItemsAdapter
import com.github.juliocesarlb.alunoResponsavel_rm94543.model.ItemModel
import com.github.juliocesarlb.alunoResponsavel_rm94543.ui.theme.AlunoResponsavel_RM94543Theme

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewLista);
        val itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.buttonIncluir)
        val editTextPraia = findViewById<EditText>(R.id.editTextPraia)
        val editTextCidade = findViewById<EditText>(R.id.editTextCidade)
        val editTextEstado = findViewById<EditText>(R.id.editTextEstado)

        button.setOnClickListener {
            if (editTextPraia.text.isEmpty()  ) {
                editTextPraia.error = "Preencha um valor"
                return@setOnClickListener
            }

            if (editTextCidade.text.isEmpty()  ) {
                editTextCidade.error = "Preencha um valor"
                return@setOnClickListener
            }
            if (editTextEstado.text.isEmpty()  ) {
                editTextEstado.error = "Preencha um valor"
                return@setOnClickListener
            }

            if (editTextEstado.text.toString().length<3  ) {
                editTextEstado.error = "Tamanho insuficiente (necessário mais que 3)"
                return@setOnClickListener
            }
            if (editTextCidade.text.toString().length<3  ) {
                editTextCidade.error = "Tamanho insuficiente (necessário mais que 3)"
                return@setOnClickListener
            }
            if (editTextPraia.text.toString().length<3  ) {
                editTextPraia.error = "Tamanho insuficiente (necessário mais que 3)"
                return@setOnClickListener
            }



            val praia = ItemModel(
                praia = editTextPraia.text.toString(),
                estado = editTextEstado.text.toString(),
                cidade = editTextCidade.text.toString(),
                onRemove = {
                    itemsAdapter.removeItem(it)
                }
            )

            itemsAdapter.addItem(praia)
            editTextPraia.text.clear()
            editTextEstado.text.clear()
            editTextCidade.text.clear()


        }
    }
}