package com.linhtetko.custom_view_assignment.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.linhtetko.custom_view_assignment.fragments.ProjectTasksFragment

class ProfileTabViewPagerAdapter(val tabs: List<String>, fragmentManager: FragmentManager, lifecycleOwner: LifecycleOwner) :
    FragmentStateAdapter(fragmentManager, lifecycleOwner.lifecycle) {

    override fun getItemCount(): Int = tabs.size

    override fun createFragment(position: Int): Fragment {
        return ProjectTasksFragment()
    }
}