package com.example.mvvm_authentication.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_authentication.model.Conta
import com.example.mvvm_authentication.repository.ContaRepository

class ContentViewModel : ViewModel() {


    private val _contas = MutableLiveData<List<Conta>>()
    val contas: LiveData<List<Conta>> = _contas

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    val contaRepository = ContaRepository()

    fun fetchContas() {
        contaRepository.fetchContas { contas, error ->
            if (error != null) {
                _error.value = error
            } else {
                _contas.value = contas
            }
        }
    }
}