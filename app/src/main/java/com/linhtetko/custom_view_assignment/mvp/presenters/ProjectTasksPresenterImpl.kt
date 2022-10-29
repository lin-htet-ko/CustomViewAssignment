package com.linhtetko.custom_view_assignment.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.linhtetko.custom_view_assignment.mvp.views.ProjectTasksView

class ProjectTasksPresenterImpl: ViewModel(), ProjectTasksPresenter {

    private var mView: ProjectTasksView? = null

    override fun initView(view: ProjectTasksView) {
        mView = view
    }

    override fun onUiReady(owner: LifecycleOwner) {
        
    }

    override fun onTapProfile() {
        
    }

    override fun onTapAdd() {
        
    }
}