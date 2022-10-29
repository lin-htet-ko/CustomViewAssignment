package com.linhtetko.custom_view_assignment.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.linhtetko.custom_view_assignment.R
import com.linhtetko.custom_view_assignment.adapters.ProfileItemDecoration
import com.linhtetko.custom_view_assignment.adapters.ProfileListAdapter
import com.linhtetko.custom_view_assignment.adapters.TaskAdapter
import com.linhtetko.custom_view_assignment.data.vos.ProfileVO
import com.linhtetko.custom_view_assignment.mvp.presenters.MainPresenter
import com.linhtetko.custom_view_assignment.mvp.presenters.MainPresenterImpl
import com.linhtetko.custom_view_assignment.mvp.views.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var presenter: MainPresenter
    private lateinit var profileAdapter: ProfileListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpPresenter()

        setUpProfileAdapter()
        setUpTaskAdapter()

        presenter.onUiReady(this)
    }

    private fun setUpPresenter() {
        presenter = ViewModelProvider(this)[MainPresenterImpl::class.java]
        presenter.initView(this)

    }

    private fun setUpProfileAdapter() {
        profileAdapter = ProfileListAdapter(listOf(), presenter, presenter)
        rvMainProfiles.adapter = profileAdapter
        rvMainProfiles.addItemDecoration(ProfileItemDecoration())
    }

    private fun setUpTaskAdapter() {
        rvMainTasks.adapter = TaskAdapter(presenter, presenter)
    }

    override fun navigateToProfile() {
        startActivity(ProfileActivity.newIntent(this))
    }

    override fun navigateToCreateTask() {
        startActivity(CreateTaskActivity.newIntent(this))
    }

    override fun setUpProfileData(profiles: MutableList<ProfileVO>) {
        profileAdapter.setItems(profiles)
    }
}