package com.example.snackbar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.snackbar.domain.Usuario
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var usuario = intent.getSerializableExtra("usuario") as? Usuario

        val home = HomeFragment.newInstance()
        val entradas = EntradasFragment.newInstance()
        val gastos = GastosFragment.newInstance()

        changeFragment(home, false)

        btn_home.setOnClickListener{ changeFragment(home, true) }
        btn_entradas.setOnClickListener{ changeFragment(entradas, true) }
        btn_gastos.setOnClickListener{ changeFragment(gastos, true) }

        Log.e("MainActivity", usuario.toString())
    }

    fun changeFragment(fragment: Fragment, addToBackStack: Boolean) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, fragment)
            if (addToBackStack) addToBackStack(null)
            commit()
        }
    }
}