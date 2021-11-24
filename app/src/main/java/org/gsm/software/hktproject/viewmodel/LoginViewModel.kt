package org.gsm.software.hktproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.gsm.software.hktproject.model.LoginRequest
import org.gsm.software.hktproject.model.LoginResponse
import org.gsm.software.hktproject.model.users.UserApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(private val api : UserApi):ViewModel(){
    private val _toastM = MutableLiveData<String>()
    val toastM : LiveData<String> get() =  _toastM

    private val _registerResultInt = MutableLiveData<Int>()
    val registerResponseInt: LiveData<Int> get() = _registerResultInt



    fun login(id:String,password:String){
        if(id.isNotEmpty() || password.isNotEmpty() ){
            _toastM.value = "아이디와 비밀번호를 모두 입력해주세요"
            _registerResultInt.value = 1
        }else{
            api.login(LoginRequest(id = id,pwd = password)).enqueue(object : Callback<LoginResponse>{
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                   if (response.isSuccessful){
                       _toastM.value = "로그인 성공"
                       _registerResultInt.value = 2
                   }else if(response!!.code() in 400..499){
                        _toastM.value  = "요청오류"
                   }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    _toastM.value = "$t"
                }
            })
        }
    }
}