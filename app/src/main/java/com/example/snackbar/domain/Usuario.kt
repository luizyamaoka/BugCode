package com.example.snackbar.domain

import java.io.Serializable

class Usuario(val id: Int, var username: String, var senha: String) : Serializable {
    override fun toString(): String {
        return "Usuario(id=$id, username='$username', senha='$senha')"
    }

}