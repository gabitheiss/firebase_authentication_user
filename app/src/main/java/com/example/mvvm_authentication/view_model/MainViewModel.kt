package com.example.mvvm_authentication.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_authentication.repository.AuthenticationRepository
import com.google.firebase.auth.FirebaseUser

class MainViewModel : ViewModel() {

    private val _user = MutableLiveData<FirebaseUser?>()
    var user : LiveData<FirebaseUser?> = _user

    private val repository = AuthenticationRepository()

   fun createNewAcconunt(email: String, password: String){
       repository.createAccontWithEmailPassword(email,password) {
           _user.value = it
       }
   }

}