package com.linhtetko.custom_view_assignment.mvp.presenters

import com.linhtetko.custom_view_assignment.mvp.views.ProfileView

interface ProfilePresenter {

    fun initView(view: ProfileView)
    fun onTapBack()
}