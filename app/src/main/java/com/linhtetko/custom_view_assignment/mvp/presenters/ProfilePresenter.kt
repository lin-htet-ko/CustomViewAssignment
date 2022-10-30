package com.linhtetko.custom_view_assignment.mvp.presenters

import com.linhtetko.custom_view_assignment.delegate.ProfileActionsDelegate
import com.linhtetko.custom_view_assignment.mvp.views.ProfileView

interface ProfilePresenter: ProfileActionsDelegate {

    fun initView(view: ProfileView)
    fun onTapBack()
}