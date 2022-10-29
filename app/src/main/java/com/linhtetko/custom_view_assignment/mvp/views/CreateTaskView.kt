package com.linhtetko.custom_view_assignment.mvp.views

import com.linhtetko.custom_view_assignment.data.vos.CategoryVO
import com.linhtetko.custom_view_assignment.data.vos.ProfileVO

interface CreateTaskView {
    fun setUpAssigneeData(assignees: List<ProfileVO>)
    fun setUpCategories(categories: List<CategoryVO>)
    fun popToPreviousScreen()
}