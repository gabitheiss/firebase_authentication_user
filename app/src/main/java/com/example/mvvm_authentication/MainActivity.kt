package com.example.mvvm_authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mvvm_authentication.view.ContentFragment
import com.example.mvvm_authentication.view.ContentFragment.Companion.newInstance
import com.example.mvvm_authentication.view.MainFragment.Companion.newInstance
import com.example.mvvm_authentication.view.SigInFragment
import com.example.mvvm_authentication.view.SignUpFragment.Companion.newInstance
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (FirebaseAuth.getInstance().currentUser != null) {
            replaceView(ContentFragment.newInstance())
        } else {
            replaceView(SigInFragment.newInstance())
        }
    }

    fun replaceView(frag: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, frag)
            .commitNow()

    }
}