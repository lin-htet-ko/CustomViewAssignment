package com.linhtetko.custom_view_assignment.mvp.presenters

import com.linhtetko.custom_view_assignment.delegate.AddTaskDelegate
import com.linhtetko.custom_view_assignment.delegate.ProfileItemDelegate
import com.linhtetko.custom_view_assignment.mvp.views.MainView

interface MainPresenter: BasePresenter, ProfileItemDelegate, AddTaskDelegate{
    fun initView(mainView: MainView)
}