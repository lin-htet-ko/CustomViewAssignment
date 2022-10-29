package com.linhtetko.custom_view_assignment.mvp.views

import com.linhtetko.custom_view_assignment.data.vos.ProfileVO

interface MainView {

    fun navigateToProfile()
    fun navigateToCreateTask()
    fun setUpProfileData(profiles: MutableList<ProfileVO>)
}