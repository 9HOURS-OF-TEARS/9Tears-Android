package org.gsm.software.hktproject.view.activity

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelStoreOwner
import com.google.android.material.textfield.TextInputLayout
import org.gsm.software.hktproject.R
import org.gsm.software.hktproject.databinding.ActivitySignupBinding
import org.gsm.software.hktproject.viewmodel.LoginViewModel
import org.gsm.software.hktproject.viewmodel.SinupViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.regex.Pattern

class SignupActivity : AppCompatActivity(), ViewModelStoreOwner {
    private val bind by lazy { ActivitySignupBinding.inflate(layoutInflater) }
    private val viewmodel: SinupViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)
        bind.activity = this
    }

    fun goLogin(){
        startActivity(Intent(this,LoginActivity::class.java))
    }

    fun idCheck() {
        viewmodel.sameIdCheck(bind.signupEmail.text.toString())
        viewmodel.check.observe(this, Observer {
            if (it) {
                viewmodel.checkResult.observe(this, Observer {
                    Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show()
                })
            } else {
                viewmodel.checkResult.observe(this, Observer {
                    Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show()
                })
            }
        })
    }

    fun nameCheck() {
        viewmodel.sameIdCheck(bind.signupNickname.text.toString())
        viewmodel.check.observe(this, Observer {
            if (it) {
                viewmodel.checkResult.observe(this, Observer {
                    Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show()
                })
            } else {
                viewmodel.checkResult.observe(this, Observer {
                    Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show()
                })
            }
        })
    }

    fun signup() {
        viewmodel.register(
            bind.signupEmail.text.toString(),
            bind.signupPw.text.toString(),
            bind.signupNickname.text.toString()
        )

        viewmodel.registerResponseInt.observe(this, Observer { it ->
            if (it == "1") {
                Toast.makeText(this, "???????????? ??????!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else if (it == "2") {
                viewmodel.registerResponse.observe(this, Observer {
                    Log.d(TAG, "signup: ${it}")
                })
            } else if (it == "3") {
                viewmodel.registerResponse.observe(this, Observer {
                    Log.d(TAG, "signup: $it")
                })
            } else {
                viewmodel.registerResponse.observe(this, Observer {
                    Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show()
                })
            }

        })


    }

    fun checkEmaill(): Boolean {
        val email = bind.signupEmail.text.toString().trim()
        val emailValidation =
            "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\$"
        val p = Pattern.matches(emailValidation, email) // ?????? ????????? ???????
        return p && email.length > 6
    }

    fun checkNickName(): Boolean {
        val nickname = bind.signupNickname.toString().trim()
        val nameValidation = "^[a-zA-Z???-???]*\$ "
        val p = Pattern.matches(nameValidation, nickname)
        return p
    }

    private fun textWatcher() {
        bind.signupEmail.addTextChangedListener(object : TextWatcher,
            TextInputLayout.OnEditTextAttachedListener {
            override fun afterTextChanged(s: Editable?) {
                // text??? ????????? ??? ??????
                // s?????? ?????? ?????? ???????????? ?????? ??????.
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // text??? ???????????? ??? ??????
                // s?????? ?????? ??? ???????????? ?????? ??????.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // text??? ?????? ????????? ????????????.
                // ?????? ??? ????????? ????????????.

            }

            override fun onEditTextAttached(textInputLayout: TextInputLayout) {
                checkNickName()
                checkEmaill()
            }
        })
    }

}


