package org.gsm.software.hktproject.view.activity

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.Observer
import org.gsm.software.hktproject.R
import org.gsm.software.hktproject.databinding.ActivityLoginBinding
import org.gsm.software.hktproject.viewmodel.LoginViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val bind by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    val loginViewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)
        bind.activity = this
    }

    fun goSignup() {
        val intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }

    fun login() {
        loginViewModel.login(bind.loginEmail.toString(), bind.loginPassword.toString())
        loginViewModel.registerResponseInt.observe(this, Observer {
            if (it == 1) {
                Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show()
            }else if(it == 2){
                startActivity(Intent(this,Any::class.java))
            }
            else {
                Log.d(TAG, "login: $it")
            }
        })
    }

}