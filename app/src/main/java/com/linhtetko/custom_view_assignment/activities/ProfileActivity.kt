package com.linhtetko.custom_view_assignment.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.linhtetko.custom_view_assignment.R
import com.linhtetko.custom_view_assignment.adapters.ProfileTabViewPagerAdapter
import com.linhtetko.custom_view_assignment.mvp.presenters.ProfilePresenter
import com.linhtetko.custom_view_assignment.mvp.presenters.ProfilePresenterImpl
import com.linhtetko.custom_view_assignment.mvp.views.ProfileView
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity(), ProfileView {

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, ProfileActivity::class.java)
            return intent
        }
    }

    private lateinit var presenter: ProfilePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setUpPresenter()
        setUpTabLayout()
        setUpListener()
    }

    private fun setUpListener() {
        btnProfileClose.setOnClickListener { presenter.onTapBack() }
    }

    private fun setUpPresenter() {
        presenter = ViewModelProvider(this)[ProfilePresenterImpl::class.java]
        presenter.initView(this)
    }

    private fun setUpTabLayout() {
        val tabs = listOf(
            "Project Tasks", "Contacts", "About Us"
        )
        vpProfileContent.adapter = ProfileTabViewPagerAdapter(tabs, supportFragmentManager, this)

        TabLayoutMediator(
            tlContent, vpProfileContent
        ) { tab, position ->
            tab.text = tabs[position]
        }.attach()

    }

    override fun navigateToBack() {
        super.onBackPressed()
    }
}