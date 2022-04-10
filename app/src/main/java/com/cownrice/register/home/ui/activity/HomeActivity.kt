package com.cownrice.register.home.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.cownrice.register.R
import com.cownrice.register.home.data.repository.service.RegisterService
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val bundle = intent.extras
        val email = bundle?.getString("email")
        setUp(email)
    }

    private fun setUp(email: String?) {
        title = "Home"
        btnLogOut.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }
        btnRegisterVisit.setOnClickListener{
            if (txtCodeCompany.text.isNotEmpty()) {
                Log.i("formulario",txtCodeCompany.text.toString())
                val register = RegisterService()
                if (email != null) {
                    register.save(email,txtCodeCompany.text.toString())
                }
            }
        }
    }
}