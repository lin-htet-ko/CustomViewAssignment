package com.linhtetko.custom_view_assignment.mvp.presenters

import androidx.lifecycle.LifecycleOwner

interface BasePresenter {
    fun onUiReady(owner: LifecycleOwner)
}