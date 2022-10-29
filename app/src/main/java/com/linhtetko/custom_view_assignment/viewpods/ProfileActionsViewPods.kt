package com.linhtetko.custom_view_assignment.viewpods

import android.content.Context
import androidx.appcompat.widget.LinearLayoutCompat
import com.linhtetko.custom_view_assignment.delegate.ProfileActionsDelegate
import kotlinx.android.synthetic.main.viewpod_profile_actions.view.*

class ProfileActionsViewPods(context: Context) : LinearLayoutCompat(context) {

    private var mDelegate : ProfileActionsDelegate? = null

    init {
        btnProfileActionShare.setOnClickListener { mDelegate?.onTapShare() }
        btnProfileActionMessage.setOnClickListener { mDelegate?.onTapMessage() }
        btnProfileActionDone.setOnClickListener { mDelegate?.onTapDoneTasks() }
    }

    fun setUpDelegate(delegate: ProfileActionsDelegate){
        mDelegate = delegate
    }
}