package com.linhtetko.custom_view_assignment.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.linhtetko.custom_view_assignment.R
import com.linhtetko.custom_view_assignment.adapters.AttachFilesAdapter
import com.linhtetko.custom_view_assignment.adapters.CategoryAdapter
import com.linhtetko.custom_view_assignment.adapters.ProfileItemDecoration
import com.linhtetko.custom_view_assignment.adapters.ProfileListAdapter
import com.linhtetko.custom_view_assignment.data.vos.CategoryVO
import com.linhtetko.custom_view_assignment.data.vos.ProfileVO
import com.linhtetko.custom_view_assignment.mvp.presenters.CreateTaskPresenter
import com.linhtetko.custom_view_assignment.mvp.presenters.CreateTaskPresenterImpl
import com.linhtetko.custom_view_assignment.mvp.views.CreateTaskView
import com.linhtetko.custom_view_assignment.utils.getNextOneYear
import com.linhtetko.custom_view_assignment.utils.getPreviousOneYear
import kotlinx.android.synthetic.main.activity_create_task.*

class CreateTaskActivity : AppCompatActivity(), CreateTaskView {

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, CreateTaskActivity::class.java)
            return intent
        }
    }

    private lateinit var presenter: CreateTaskPresenter
    private lateinit var profileAdapter: ProfileListAdapter
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)

        setUpPresenter()
        setUpAssigneeAdapter()
        setUpCategoryAdapter()
        setUpDeadLinesAdapter()
        setUpClientAdapter()
        setUpAttachmentFileAdapter()

        setOnClickListener()

        presenter.onUiReady(this)
    }

    private fun setOnClickListener() {
        btnCreateTaskBack.setOnClickListener { presenter.onTapBack() }
    }

    private fun setUpAttachmentFileAdapter() {
        rvCreateTasksAttach.adapter = AttachFilesAdapter()
    }

    private fun setUpClientAdapter() {
        spCreateTaskTeams.adapter = ArrayAdapter(
            this,
            R.layout.spinner_item,
            listOf(
                "Aeon Display and Security System",
                "Parrot Film Company",
                "Red Link Communications",
                "Wave Money"
            )
        )
    }

    private fun setUpDeadLinesAdapter() {
        spCreateTaskStartDate.adapter =
            ArrayAdapter(this, R.layout.spinner_item, getPreviousOneYear())
        spCreateTaskEndDate.adapter = ArrayAdapter(this, R.layout.spinner_item, getNextOneYear())
    }

    private fun setUpPresenter() {
        presenter = ViewModelProvider(this)[CreateTaskPresenterImpl::class.java]
        presenter.initView(this)
    }

    private fun setUpAssigneeAdapter() {
        profileAdapter = ProfileListAdapter(listOf(), presenter, presenter)
        rvCreateTasksAssignee.adapter = profileAdapter
        rvCreateTasksAssignee.addItemDecoration(ProfileItemDecoration())
    }

    private fun setUpCategoryAdapter() {
        categoryAdapter = CategoryAdapter(listOf())
        rvCreateTasksCategories.adapter = categoryAdapter
    }

    override fun setUpAssigneeData(assignees: List<ProfileVO>) {
        profileAdapter.setItems(assignees)
    }

    override fun setUpCategories(categories: List<CategoryVO>) {
        categoryAdapter.setItems(categories)
    }

    override fun popToPreviousScreen() {
        super.onBackPressed()
    }
}