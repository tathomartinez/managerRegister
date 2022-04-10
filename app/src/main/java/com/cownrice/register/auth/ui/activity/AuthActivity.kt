package com.cownrice.register.auth.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.cownrice.register.R
import com.cownrice.register.home.ui.activity.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.android.synthetic.main.activity_auth.view.*

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        setUp()
    }

    @SuppressLint("WrongViewCast")
    private fun setUp() {
        title = "Login"
        btnRegister.setOnClickListener {
            if (txtEmail.text.isNotEmpty() && txtPass.text.isNotEmpty()) {
                Log.i("LOGIN", "Entro a el registro")
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    txtEmail.text.toString(), txtPass.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showHome(txtEmail.text.toString())
                    } else {
                        showAlert()
                    }
                }
            }
        }

        btnLogin.setOnClickListener {
            if (txtEmail.text.isNotEmpty() && txtPass.text.isNotEmpty()) {
                Log.i("LOGIN", "Entro a el registro")
                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    txtEmail.text.toString(), txtPass.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showHome(txtEmail.text.toString())
                    } else {
                        showAlert()
                    }
                }
            }
        }
    }

    private fun showAlert() {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autentificando al usuario")
        builder.setPositiveButton("Aceptar", null)

        var dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email: String) {
        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra("email", email)
        }
        startActivity(homeIntent)

    }

}
