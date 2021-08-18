package com.example.mvvm_authentication.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.mvvm_authentication.MainActivity
import com.example.mvvm_authentication.R
import com.example.mvvm_authentication.utils.replaceView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseUser

class SigInFragment : Fragment(R.layout.sigin_fragment) {


    private lateinit var viewModel: SigInViewModel

    private val observerUser = Observer<FirebaseUser> {
        requireActivity().replaceView(ContentFragment.newInstance())
    }



    private val observerError = Observer<String> {

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(SigInViewModel::class.java)


        viewModel.error.observe(viewLifecycleOwner, observerError)
        viewModel.user.observe(viewLifecycleOwner, observerUser)


        /**
         * Add eventos nos componentes da tela
         */
        view.findViewById<Button>(R.id.loginButton).setOnClickListener {
            val inputEmail = view.findViewById<EditText>(R.id.inputEmailEditText)
            val inputPassword = view.findViewById<EditText>(R.id.inputPasswordEditText)
            if (!inputEmail.text.isNullOrEmpty() && !inputPassword.text.isNullOrEmpty()) {
                viewModel.signIn(
                    inputEmail.text.toString(),
                    inputPassword.text.toString()
                )
            }
        }

        view.findViewById<View>(R.id.newAccountTextView).setOnClickListener {
            (requireActivity() as? MainActivity)?.replaceView(SignUpFragment.newInstance())
        }
    }


}