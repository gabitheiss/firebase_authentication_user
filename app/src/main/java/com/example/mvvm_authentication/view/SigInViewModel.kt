package com.example.mvvm_authentication.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_authentication.repository.AuthenticationRepository
import com.google.firebase.auth.FirebaseUser

class SigInViewModel : ViewModel() {

    private val _user = MutableLiveData<FirebaseUser>()
    val user: LiveData<FirebaseUser> = _user

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val authenticationRepository = AuthenticationRepository()

    fun signIn(email: String, password: String) {
        authenticationRepository.sigInWithEmailPassword(email, password) { firebaseUser, error ->
            if (firebaseUser != null) {
                _user.value = firebaseUser
            } else {
                _error.value = error ?: "Erro desconhecido"
            }
        }
    }


}