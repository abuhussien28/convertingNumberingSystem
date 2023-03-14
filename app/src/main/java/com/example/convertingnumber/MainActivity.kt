package com.example.convertingnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.convertingnumber.fragment.CovertScreen
import com.example.convertingnumber.fragment.OperationScreen
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(CovertScreen())
        val bottomAppNavigationButton: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomAppNavigationButton.setOnItemReselectedListener {
            when (it.itemId) {
                R.id.convert -> replaceFragment(CovertScreen())
                R.id.calculator -> replaceFragment(OperationScreen())
            }
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, fragment).commit()
        }
    }
}