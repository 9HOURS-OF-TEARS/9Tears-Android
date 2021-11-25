package org.gsm.software.hktproject.view.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.gsm.software.hktproject.R
import org.gsm.software.hktproject.viewmodel.RecentlyPostViewModel

class Recently_Post : Fragment() {

    companion object {
        fun newInstance() = Recently_Post()
    }

    private lateinit var viewModel: RecentlyPostViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recently__post_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecentlyPostViewModel::class.java)
        // TODO: Use the ViewModel
    }

}