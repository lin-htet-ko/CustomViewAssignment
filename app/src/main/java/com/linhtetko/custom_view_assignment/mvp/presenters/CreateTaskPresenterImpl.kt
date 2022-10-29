package com.linhtetko.custom_view_assignment.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.linhtetko.custom_view_assignment.adapters.CategoryAdapter
import com.linhtetko.custom_view_assignment.adapters.ProfileListActionType
import com.linhtetko.custom_view_assignment.data.vos.CategoryVO
import com.linhtetko.custom_view_assignment.data.vos.ProfileVO
import com.linhtetko.custom_view_assignment.mvp.views.CreateTaskView

class CreateTaskPresenterImpl:ViewModel(), CreateTaskPresenter {
    private var mView: CreateTaskView? = null

    override fun initView(view: CreateTaskView) {
        mView = view
    }

    override fun onTapBack() {
        mView?.popToPreviousScreen()
    }

    override fun onUiReady(owner: LifecycleOwner) {

        val list = (1..5).toList()
        val profiles = mutableListOf<ProfileVO>()

        list.forEachIndexed { index, i ->
            profiles.add(ProfileVO(type = ProfileListActionType.PROFILE))

            if (index == list.size - 1)
                profiles.add(ProfileVO(type = ProfileListActionType.ADD))
        }

        mView?.setUpAssigneeData(profiles)

        val categories = listOf(
            CategoryVO("Design", CategoryAdapter.CATEGORY_SELECTED),
            CategoryVO("Frontend", CategoryAdapter.CATEGORY_UNSELECTED),
            CategoryVO("Backend", CategoryAdapter.CATEGORY_UNSELECTED)
        )
        mView?.setUpCategories(categories)
    }

    override fun onTapProfile() {
        
    }

    override fun onTapAdd() {
        
    }

}