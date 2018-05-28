package com.example.daria.salesplaning

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.daria.salesplaning.R
import com.example.daria.salesplaning.DayFragment
import com.example.daria.salesplaning.MonthFragment
import com.example.daria.salesplaning.PersonsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val navFragments: ArrayList<Fragment> = ArrayList()

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.month -> {
                replaceFragment(navFragments[0])
                return@OnNavigationItemSelectedListener true
            }
            R.id.day -> {
                replaceFragment(navFragments[1])
                return@OnNavigationItemSelectedListener true
            }
            R.id.persons -> {
                replaceFragment(navFragments[2])
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun initViews() {
        supportActionBar?.setIcon(R.drawable.ic_main)

        navFragments.add(MonthFragment.newInstance())
        navFragments.add(DayFragment.newInstance())
        navFragments.add(PersonsFragment.newInstance())

        replaceFragment(navFragments[0])
    }

    private fun replaceFragment(fragment: Fragment) {
        val backStateName = fragment.javaClass.simpleName
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment, backStateName)
                .commitAllowingStateLoss()
    }
}
