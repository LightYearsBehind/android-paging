package com.geniewits.paging

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.geniewits.paging2.Paging2Fragment
import com.geniewits.paging3.Paging3Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigator = findViewById<BottomNavigationView>(R.id.nav)
        navigator.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_paging_2 -> {
                    swapFragment(Paging2Fragment())
                    true
                }
                R.id.navigation_paging_3 -> {
                    swapFragment(Paging3Fragment())
                    true
                }
                else -> {
                    false
                }
            }
        }

        if (savedInstanceState == null) {
            navigator.selectedItemId = R.id.navigation_paging_2
        }
    }

    private fun swapFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}