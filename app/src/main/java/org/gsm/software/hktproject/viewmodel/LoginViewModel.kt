package org.gsm.software.hktproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.gsm.software.hktproject.retrofit.Api
import org.koin.core.context.GlobalContext

class LoginViewModel(private val api : Api):ViewModel(){
    private val _toastM = MutableLiveData<String>()

    init {
        val toastM : LiveData<String> = _toastM
    }



    fun login(id:String,password:String){
        if(id.isEmpty() || password.isEmpty() ){
            _toastM.value = "아이디와 비밀번호를 모두 입력해주세요"
        }else{

        }
    }
}