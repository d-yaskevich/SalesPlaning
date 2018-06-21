package com.example.daria.salesplaning

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        supportActionBar?.setIcon(R.drawable.ic_main)
        replaceFragment(MainPagerFragment.newInstance())
    }

    private fun replaceFragment(fragment: Fragment) {
        val backStateName = fragment.javaClass.simpleName
        supportFragmentManager?.let {
            it.beginTransaction()
                    .replace(R.id.container, fragment, backStateName)
                    .commitAllowingStateLoss()
        }
    }

}
