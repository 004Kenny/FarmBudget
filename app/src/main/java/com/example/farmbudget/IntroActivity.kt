package com.example.farmbudget

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class IntroActivity : AppCompatActivity() {
    private lateinit var viewPagerAdapter: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var skipButton: View
    private lateinit var nextButton: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)



        viewPagerAdapter = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)
        skipButton = findViewById(R.id.btnSkip)
        nextButton = findViewById(R.id.btnNext)

        viewPagerAdapter.adapter = IntroPagerAdapter(this)
        TabLayoutMediator(tabLayout, viewPagerAdapter) {_, _ ->}.attach()

        skipButton.setOnClickListener { navigateToWelcomeScreen() }

        nextButton.setOnClickListener {
            if (viewPagerAdapter.currentItem < 2){
                //move to next screen
                viewPagerAdapter.currentItem += 1
            } else {
                //navigate to welcome screen
                navigateToWelcomeScreen()
            }
        }

        viewPagerAdapter.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 2){
                    //hides the skip button and changes the next button to "finish"
                    skipButton.visibility = View.GONE
                    (nextButton as? android.widget.Button)?.text = "Finish"
                }else {
                    skipButton.visibility = View.VISIBLE
                    (nextButton as? android.widget.Button)?.text = "Next"
                }
            }
        })

    }
    private fun navigateToWelcomeScreen(){
        val intent = Intent(this, WelcomeScreenActivity::class.java)
        startActivity(intent)
        finish()
    }
}