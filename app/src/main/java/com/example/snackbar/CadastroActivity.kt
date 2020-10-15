package com.example.snackbar

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.snackbar.domain.Usuario
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.cadastro_body.*
import kotlinx.android.synthetic.main.login_body.*
import kotlinx.android.synthetic.main.cadastro_body.edPassword
import kotlinx.android.synthetic.main.cadastro_body.edUserName
import kotlinx.android.synthetic.main.toolbar.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
//        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener{
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        var usuario = intent.getSerializableExtra("usuario") as? Usuario

        edUserName.setText(usuario?.username)
        edPassword.setText(usuario?.senha)

        btnCadastro.setOnClickListener{
            when{
                edPassword.text.toString() == edPasswordConfirmation.text.toString() -> showSnackbar("Cadastro finalizado")
                else -> {
                    showSnackbar("Senha e confirmacao sao diferentes")
                    edPassword.setError("Senhas precisam ser iguais")
                }
            }
        }
    }

    fun showSnackbar(msg: String) {
        Snackbar.make(home, msg, Snackbar.LENGTH_LONG)
            .setAction("ok", View.OnClickListener {})
            .show()
    }

}