package com.example.daria.salesplaning

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main_pager.*
import kotlinx.android.synthetic.main.fragment_main_pager.view.*

class MainPagerFragment : Fragment(), ViewPager.OnPageChangeListener {

    companion object {
        fun newInstance(): MainPagerFragment {
            return MainPagerFragment()
        }
    }

    private var pagerView: ViewPager? = null
    private val navFragments: ArrayList<Fragment> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main_pager, null)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        navFragments.add(MonthFragment.newInstance())
        navFragments.add(DayFragment.newInstance())
        navFragments.add(PersonsFragment.newInstance())

        view.navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.month -> {
                    pager.currentItem = 0; true
                }
                R.id.day -> {
                    pager.currentItem = 1
                    true
                }
                R.id.persons -> {
                    pager.currentItem = 2
                    true
                }
                else -> false
            }
        }

        pagerView = view.pager
        pagerView?.offscreenPageLimit = 2
        pagerView?.adapter = object : FragmentPagerAdapter(childFragmentManager) {
            override fun getItem(position: Int): Fragment = navFragments[position]

            override fun getItemPosition(`object`: Any): Int = PagerAdapter.POSITION_NONE

            override fun getCount(): Int = navFragments.size
        }
        pagerView?.addOnPageChangeListener(this)
    }

    override fun onPageScrollStateChanged(state: Int) {  }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {  }

    override fun onPageSelected(position: Int) {
        when(position){
            0 -> navigation.selectedItemId = R.id.month
            1 -> navigation.selectedItemId = R.id.day
            2 -> navigation.selectedItemId = R.id.persons
        }
    }


    private fun replaceFragment(fragment: Fragment) {
        val backStateName = fragment.javaClass.simpleName
        fragmentManager?.let {
            it.beginTransaction()
                    .replace(R.id.container, fragment, backStateName)
                    .commitAllowingStateLoss()
        }
    }
}