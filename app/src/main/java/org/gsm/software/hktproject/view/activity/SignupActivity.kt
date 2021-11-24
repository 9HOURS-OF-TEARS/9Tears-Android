package org.gsm.software.hktproject.view.activity

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelStoreOwner
import org.gsm.software.hktproject.R
import org.gsm.software.hktproject.databinding.ActivitySignupBinding
import org.gsm.software.hktproject.viewmodel.LoginViewModel
import org.gsm.software.hktproject.viewmodel.SinupViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignupActivity : AppCompatActivity(),ViewModelStoreOwner {
    private val bind by lazy { ActivitySignupBinding.inflate(layoutInflater) }
    private val viewmodel :SinupViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)
        bind.activity = this
    }

    fun signup() {
        viewmodel.register(
            bind.signupEmail.toString(),
            bind.signupPw.toString(),
            bind.signupNickname.toString()
        )
        viewmodel.registerResponseInt.observe(this, Observer {
            if(it == "1"){
                val intent = Intent(this,Any::class.java)
                startActivity(intent)
            }else if(it == "2"){
                viewmodel.registerResponse.observe(this, Observer {
                    Log.d(TAG, "signup: ${it}")
                })
            }else if(it == "3"){
                viewmodel.registerResponse.observe(this, Observer {
                    Log.d(TAG, "signup: $it")
                })
            }else{
                viewmodel.registerResponse.observe(this, Observer {
                    Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show()
                })
            }

        })

        Log.d(TAG, "signup: ${viewmodel.registerResponse}")
    }


}