package com.example.daria.salesplaning

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_month.view.*

class MonthFragment: Fragment() {

    companion object {
        fun newInstance(): MonthFragment {
            return MonthFragment()
        }
    }

    override fun onStart() {
        super.onStart()
        //
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_month, null)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        view.text.text = getString(R.string.title_month)
    }
}