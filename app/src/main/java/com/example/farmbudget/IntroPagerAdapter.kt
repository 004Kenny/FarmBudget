package com.example.farmbudget

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class IntroPagerAdapter (activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ScreenOneFragment()
            1 -> ScreenTwoFragment()
            2 -> ScreenThreeFragment()

            else -> throw IllegalStateException("Invalid position.")
        }
    }
}