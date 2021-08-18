package com.example.mvvm_authentication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_authentication.R
import com.example.mvvm_authentication.utils.replaceView
import com.example.mvvm_authentication.view_model.MainViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseUser
import java.util.Observer

class SignUpFragment : Fragment(R.layout.sign_up_fragment) {

    companion object {

        fun newInstance() = SignUpFragment()
    }

    private lateinit var viewModel: MainViewModel
    private val observerNewUser = Observer<FirebaseUser?> {
        Snackbar.make(requireView(), "Usuário criado com sucesso!!!!", Snackbar.LENGTH_LONG).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        /**
         * Add observers
         */
        viewModel.user.observe(viewLifecycleOwner, observerNewUser)
        /**
         * Add eventos nos componentes da tela
         */
        view.findViewById<Button>(R.id.saveButton).setOnClickListener {
            val inputEmail = view.findViewById<EditText>(R.id.inputEmailEditText)
            val inputPassword = view.findViewById<EditText>(R.id.inputPasswordEditText)
            if (!inputEmail.text.isNullOrEmpty() && !inputPassword.text.isNullOrEmpty()) {
                viewModel.createNewAccount(
                    inputEmail.text.toString(),
                    inputPassword.text.toString()
                )
            }
        }


    }
    view.findViewById<View>(R.id.backButton).setOnClickListener{
    requireActivity().replaceView(SignInFragment.newInstance(), R.id.action_bar)
    }




