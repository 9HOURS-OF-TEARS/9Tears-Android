package org.gsm.software.hktproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.QuerySnapshot
import org.gsm.software.hktproject.model.users.UserApi

class MainViewModel(private val api : UserApi) :ViewModel() {

    val getAllPostNull: LiveData<Boolean> get() = _getAllPostNull
    private val _getAllPostNull: MutableLiveData<Boolean> = MutableLiveData<Boolean>()

    val getMyPostNull: LiveData<Boolean> get() = _getMyPostNull
    private val _getMyPostNull: MutableLiveData<Boolean> = MutableLiveData<Boolean>()

    val getMyPostResponse: LiveData<QuerySnapshot> get() = _getMyPostResponse
    private val _getMyPostResponse = MutableLiveData<QuerySnapshot>()

    //게시물이 없는지 체크 true = 게시물 없음, false = 게시물 있음
    fun setGetAllPostNull(check: Boolean) {
        _getAllPostNull.value = check
    }

    //게시물이 없는지 체크 true = 게시물 없음, false = 게시물 있음
    fun setGetMyPostNull(check: Boolean) {
        _getMyPostNull.value = check
    }

}