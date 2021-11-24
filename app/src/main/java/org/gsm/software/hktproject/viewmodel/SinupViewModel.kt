package org.gsm.software.hktproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.gsm.software.hktproject.model.RegisterResponse
import org.gsm.software.hktproject.model.RequestRegister
import org.gsm.software.hktproject.model.users.UserApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SinupViewModel(val api: UserApi) : ViewModel() {


    private val _registerResultInt = MutableLiveData<String>()
    val registerResponseInt: LiveData<String> get() = _registerResultInt

    private val _registerResult = MutableLiveData<String>()
    val registerResponse: LiveData<String> get() = _registerResult



    fun register(email: String, pwd: String, nick: String) {
        if (email.isNotEmpty() || pwd.isNotEmpty() || nick.isNotEmpty()) {
            _registerResult.value = "모두 입력해주세요"
            _registerResultInt.value = "4"
        } else {
            api.register(RequestRegister(id = email, pwd = pwd, nickname = nick))
                .enqueue(object : Callback<RegisterResponse> {
                    override fun onResponse(
                        call: Call<RegisterResponse>,
                        response: Response<RegisterResponse>
                    ) {
                        if (response.isSuccessful) {
                            _registerResult.value = "회원가입 성공"
                            _registerResultInt.value  = "1"
                        }else{
                            _registerResult.value = "통신오류"
                            _registerResultInt.value = "2"
                        }
                    }
                    override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                        _registerResult.value = "$t"
                        _registerResultInt.value = "3"
                    }
                })
        }
    }
}