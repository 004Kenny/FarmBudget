package com.example.farmbudget

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class IntroActivity : AppCompatActivity() {
    private lateinit var viewPagerAdapter: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        viewPagerAdapter = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)

        viewPagerAdapter.adapter = IntroPagerAdapter(this)
        TabLayoutMediator(tabLayout, viewPagerAdapter) {_, _ ->}.attach()

    }
}