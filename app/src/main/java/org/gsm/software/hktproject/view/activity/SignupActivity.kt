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

    fun signup() {
        if (!checkEmaill()) {
            Toast.makeText(this, "Email형식에 맞게 작성해주세요", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "signup: Email 체크\n${bind.signupEmail.toString()}")
        }else if(checkNickName()){
            Toast.makeText(this, "닉네임은 한글/영문만 사용해주세요", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "signup: 닉네임 체크")
        } else{
            viewmodel.register(
                bind.signupEmail.toString(),
                bind.signupPw.toString(),
                bind.signupNickname.toString()
            )
            viewmodel.registerResponseInt.observe(this, Observer { it ->
                if (it == "1") {
                    val intent = Intent(this, Any::class.java)
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

    }

    fun checkEmaill(): Boolean {
        val email = bind.signupEmail.text.toString().trim()
        val emailValidation =
            "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\$"
        val p = Pattern.matches(emailValidation, email) // 서로 패턴이 맞닝?
        return p && email.length > 6
    }

    fun checkNickName():Boolean{
        val nickname = bind.signupNickname.toString().trim()
        val nameValidation = "^[a-zA-Z가-힣]*\$ "
        val p = Pattern.matches(nameValidation,nickname)
        return p
    }

    private fun textWatcher() {
        bind.signupEmail.addTextChangedListener(object : TextWatcher,
            TextInputLayout.OnEditTextAttachedListener {
            override fun afterTextChanged(s: Editable?) {
                // text가 변경된 후 호출
                // s에는 변경 후의 문자열이 담겨 있다.
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // text가 변경되기 전 호출
                // s에는 변경 전 문자열이 담겨 있다.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // text가 바뀔 때마다 호출된다.
                // 우린 이 함수를 사용한다.

            }

            override fun onEditTextAttached(textInputLayout: TextInputLayout) {
                checkNickName()
                checkEmaill()
            }
        })
    }

}


