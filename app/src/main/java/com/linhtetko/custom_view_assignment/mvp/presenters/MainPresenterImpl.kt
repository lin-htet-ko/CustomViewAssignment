package com.linhtetko.custom_view_assignment.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.linhtetko.custom_view_assignment.adapters.ProfileListActionType
import com.linhtetko.custom_view_assignment.data.vos.ProfileVO
import com.linhtetko.custom_view_assignment.mvp.views.MainView

class MainPresenterImpl : ViewModel(), MainPresenter {

    private var mMainView: MainView? = null

    override fun initView(mainView: MainView) {
        mMainView = mainView
    }

    override fun onUiReady(owner: LifecycleOwner) {

        val list = (1..5).toList()
        val profiles = mutableListOf<ProfileVO>()

        list.forEachIndexed { index, i ->
            profiles.add(ProfileVO(type = ProfileListActionType.PROFILE))

            if (index == list.size - 1)
                profiles.add(ProfileVO(type = ProfileListActionType.ADD))
        }
        mMainView?.setUpProfileData(profiles)
    }

    override fun onTapProfile() {
        mMainView?.navigateToProfile()
    }

    override fun onTapAdd() {
        mMainView?.navigateToCreateTask()
    }
}