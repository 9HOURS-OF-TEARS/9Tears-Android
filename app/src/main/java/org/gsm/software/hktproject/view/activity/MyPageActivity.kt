package org.gsm.software.hktproject.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.gsm.software.hktproject.R
import org.gsm.software.hktproject.databinding.ActivityMyPageBinding
import org.gsm.software.hktproject.viewmodel.MainViewModel
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyPageActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMyPageBinding.inflate(layoutInflater) }
    val mainViewModel : MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.activity = this
        observeViewModel()


    }

    fun goBack(){
        finish()
    }


    private fun observeViewModel() {
        if (mainViewModel.getMyPostNull.value == true) {
            binding.myPostRecyler.visibility = View.GONE
            binding.notFound.visibility = View.VISIBLE
        }
    }
}