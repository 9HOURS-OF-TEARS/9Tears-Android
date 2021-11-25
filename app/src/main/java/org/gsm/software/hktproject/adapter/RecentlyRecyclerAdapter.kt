package org.gsm.software.hktproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.gsm.software.hktproject.R
import org.gsm.software.hktproject.databinding.RecentlyItemBinding
import org.gsm.software.hktproject.viewmodel.MainViewModel
import kotlin.properties.Delegates

class RecentlyRecyclerAdapter(mainViewModel: MainViewModel) :
    RecyclerView.Adapter<RecentlyRecyclerViewHolder>() {
    var response : ArrayList<Any> = arrayListOf()
    var count by Delegates.notNull<Int>()
    private var item : Any? = null

    init {
        response.clear()
        val snapshots = mainViewModel.getMyPostResponse.value
        if (snapshots != null) {
            for (document in snapshots) {
                item = document.toObject(Any::class.java)
                response.add(item!!)
            }
        }
        count = mainViewModel.getMyPostResponse.value!!.size()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentlyRecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding = DataBindingUtil.inflate<RecentlyItemBinding>(
            layoutInflater,
            R.layout.recently_item,
            parent,
            false
        )
        return RecentlyRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecentlyRecyclerViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return count
    }
}

class RecentlyRecyclerViewHolder(val binding: RecentlyItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Any) {
//        binding.data = data
        binding.executePendingBindings()
    }


}
