package com.linhtetko.custom_view_assignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.linhtetko.custom_view_assignment.R
import com.linhtetko.custom_view_assignment.adapters.TaskAdapter
import com.linhtetko.custom_view_assignment.mvp.presenters.ProjectTasksPresenter
import com.linhtetko.custom_view_assignment.mvp.presenters.ProjectTasksPresenterImpl
import com.linhtetko.custom_view_assignment.mvp.views.ProjectTasksView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_project_tasks.*

class ProjectTasksFragment : Fragment(), ProjectTasksView {

    private lateinit var presenter: ProjectTasksPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_project_tasks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        setUpProjectTasks()
    }

    private fun setUpPresenter() {
        presenter = ViewModelProvider(this)[ProjectTasksPresenterImpl::class.java]
        presenter.initView(this)
    }

    private fun setUpProjectTasks() {

        rvProjectTasks.adapter = TaskAdapter(presenter, presenter)
    }
}