package org.gsm.software.hktproject.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.gsm.software.hktproject.view.fragment.Popular_Post
import org.gsm.software.hktproject.view.fragment.Recently_Post

class ViewPagerFragmentAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    val fragmentList = listOf<Fragment>(Recently_Post(),Popular_Post())

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}