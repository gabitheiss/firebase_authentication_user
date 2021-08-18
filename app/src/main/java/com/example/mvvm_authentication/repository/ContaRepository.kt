package com.example.mvvm_authentication.repository

import android.util.Log
import com.example.mvvm_authentication.model.Conta
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ContaRepository {

    private val dataBase = Firebase.firestore

    fun fetchContas(callback : (List<Conta>?, String?) -> Unit) {
        dataBase.collection("contas")
            .get()
            .addOnSuccessListener { result ->

                val listOf = arrayListOf<Conta>()
                    result.forEach {
                        listOf.add(Conta.fromData(it))
                    }
                callback(listOf, null)
            }
            .addOnFailureListener{ exeption ->
                callback(null,exeption.message)
            }
    }


}