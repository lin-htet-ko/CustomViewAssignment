package com.linhtetko.custom_view_assignment.mvp.presenters

import androidx.lifecycle.ViewModel
import com.linhtetko.custom_view_assignment.mvp.views.ProfileView

class ProfilePresenterImpl: ViewModel(), ProfilePresenter {

    private var mView: ProfileView? = null

    override fun initView(view: ProfileView) {
        mView = view
    }

    override fun onTapBack() {
        mView?.navigateToBack()
    }

    override fun onTapShare() {
        
    }

    override fun onTapMessage() {
        
    }

    override fun onTapDoneTasks() {
        
    }
}