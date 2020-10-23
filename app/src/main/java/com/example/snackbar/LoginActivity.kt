package com.example.snackbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.snackbar.domain.Usuario
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.login_body.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener{
            Snackbar.make(home, "Senha invalida", Snackbar.LENGTH_LONG)
                .setAction("ok", View.OnClickListener {})
                .show()
        }

//        nao_tem_cadastro.setOnClickListener{
//            var intent = Intent(this, CadastroActivity::class.java)
//            intent.putExtra("usuario", getUsuario())
//            startActivity(intent)
//        }

        nao_tem_cadastro.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("usuario", getUsuario())
            startActivity(intent)
        }
    }

    fun getUsuario(): Usuario = Usuario(1, edUserName.text.toString(), edPassword.text.toString())
}