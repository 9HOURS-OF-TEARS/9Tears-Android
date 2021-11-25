package org.gsm.software.hktproject.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.gsm.software.hktproject.view.fragment.Popular_Post
import org.gsm.software.hktproject.view.fragment.PrettyCommentFragment
import org.gsm.software.hktproject.view.fragment.PrettyContentFragment
import org.gsm.software.hktproject.view.fragment.Recently_Post

class LankAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    val fragmentList = listOf<Fragment>(PrettyContentFragment(), PrettyCommentFragment())

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}