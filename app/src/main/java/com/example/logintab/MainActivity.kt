package com.example.logintab

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var viewPager = findViewById<ViewPager>(R.id.viewpage)
        var tablayout = findViewById<TabLayout>(R.id.tablayout)

        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(newsfeed(), "Flights")
        fragmentAdapter.addFragment(Home(), "Trips")
        fragmentAdapter.addFragment(Profile(), "Explore")
        viewPager.adapter = fragmentAdapter
        tablayout.setupWithViewPager(viewPager)

        tablayout.getTabAt(0)?.setIcon(R.drawable.airport)
        tablayout.getTabAt(1)?.setIcon(R.drawable.trekking)
        tablayout.getTabAt(2)?.setIcon(R.drawable.explore)
    }
}