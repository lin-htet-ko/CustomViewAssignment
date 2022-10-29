package com.linhtetko.custom_view_assignment.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.linhtetko.custom_view_assignment.adapters.ProfileItemDecoration
import com.linhtetko.custom_view_assignment.adapters.ProfileListAdapter
import com.linhtetko.custom_view_assignment.data.vos.ProfileVO
import com.linhtetko.custom_view_assignment.delegate.AddTaskDelegate
import com.linhtetko.custom_view_assignment.delegate.ProfileItemDelegate
import kotlinx.android.synthetic.main.viewholder_task.view.*

class TaskViewHolder(
    itemView: View,
    private val profileItemDelegate: ProfileItemDelegate,
    private val addTaskDelegate: AddTaskDelegate
) :
    RecyclerView.ViewHolder(itemView) {


    fun bindData(profiles: List<ProfileVO>) {
        itemView.ivTaskProfiles.adapter = ProfileListAdapter(profiles, profileItemDelegate, addTaskDelegate)
        itemView.ivTaskProfiles.addItemDecoration(ProfileItemDecoration())
    }
}