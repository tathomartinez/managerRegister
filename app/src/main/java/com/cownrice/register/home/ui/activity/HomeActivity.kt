package com.cownrice.register.home.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cownrice.register.R
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
    }
}