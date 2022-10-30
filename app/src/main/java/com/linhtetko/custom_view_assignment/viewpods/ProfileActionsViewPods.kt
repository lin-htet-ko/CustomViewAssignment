package com.linhtetko.custom_view_assignment.viewpods

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.LinearLayoutCompat
import com.linhtetko.custom_view_assignment.delegate.ProfileActionsDelegate
import kotlinx.android.synthetic.main.viewpod_profile_actions.view.*

class ProfileActionsViewPods @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayoutCompat(context, attrs) {

    private var mDelegate : ProfileActionsDelegate? = null

    fun setUpDelegate(delegate: ProfileActionsDelegate){
        mDelegate = delegate
        setUpListener()
    }

    private fun setUpListener() {
        btnProfileActionShare.setOnClickListener { mDelegate?.onTapShare() }
        btnProfileActionMessage.setOnClickListener { mDelegate?.onTapMessage() }
        btnProfileActionDone.setOnClickListener { mDelegate?.onTapDoneTasks() }
    }
}