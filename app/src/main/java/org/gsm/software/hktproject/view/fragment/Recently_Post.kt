package org.gsm.software.hktproject.view.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import org.gsm.software.hktproject.R
import org.gsm.software.hktproject.adapter.RecentlyRecyclerAdapter
import org.gsm.software.hktproject.databinding.RecentlyPostFragmentBinding
import org.gsm.software.hktproject.util.showVertical
import org.gsm.software.hktproject.viewmodel.MainViewModel
import org.gsm.software.hktproject.viewmodel.RecentlyPostViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class Recently_Post : Fragment() {
    lateinit var binding: RecentlyPostFragmentBinding
    private val mainViewModel: MainViewModel by viewModel()


    private lateinit var viewModel: RecentlyPostViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.recently__post_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecentlyPostViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun observeViewModel() {
        if (mainViewModel.getMyPostNull.value == true) {
            binding.recentlyPostRecyclerView.visibility = View.GONE
            binding.notFound.visibility = View.VISIBLE
        }



    }

    private fun initRecyclerView(){
        binding.recentlyPostRecyclerView.showVertical(requireContext())
        binding.recentlyPostRecyclerView.adapter = RecentlyRecyclerAdapter(mainViewModel)
    }
}