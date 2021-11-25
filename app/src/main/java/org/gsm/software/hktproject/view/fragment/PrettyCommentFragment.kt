package org.gsm.software.hktproject.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import org.gsm.software.hktproject.R
import org.gsm.software.hktproject.viewmodel.PrettycommentViewModel
import org.gsm.software.hktproject.viewmodel.PrettycontentViewModel


class PrettyCommentFragment  : Fragment() {

    companion object {
        fun newInstance() = PrettycommentViewModel()
    }

    private lateinit var viewModel: PrettycommentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pretty_comment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PrettycommentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}