package com.example.mvvm_authentication.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthenticationRepository {

    private val auth = FirebaseAuth.getInstance()


//    fun sigInWithEmailPassword(email: String, password: String) {
//
//    }

    fun createAccontWithEmailPassword(email: String, password: String, callback: (FirebaseUser?)-> Unit){
        val task = auth.createUserWithEmailAndPassword(email,password)
        task.addOnSuccessListener { authResult ->
            callback(authResult.user)
        }
    }
}