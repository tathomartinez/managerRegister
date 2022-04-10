package com.cownrice.register.home.data.repository.service

import com.cownrice.register.home.data.model.Registro
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class RegisterService {
    private val db = FirebaseFirestore.getInstance()
    private lateinit var database: DatabaseReference

    fun save(email: String, codeCompany: String) {
        database = Firebase.database.reference

        val coleccionFire = "visits"
        database.child(coleccionFire).setValue(Registro(email, codeCompany))
    }

}