package org.gsm.software.hktproject.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import org.gsm.software.hktproject.R
import org.gsm.software.hktproject.viewmodel.PopularPostViewModel
import org.gsm.software.hktproject.viewmodel.PrettycontentViewModel


class PrettyContentFragment  : Fragment() {

    companion object {
        fun newInstance() = Popular_Post()
    }

    private lateinit var viewModel: PrettycontentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_prettycontent, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PrettycontentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}