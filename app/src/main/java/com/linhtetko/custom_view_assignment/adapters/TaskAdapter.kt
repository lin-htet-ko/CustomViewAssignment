package com.linhtetko.custom_view_assignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.linhtetko.custom_view_assignment.R
import com.linhtetko.custom_view_assignment.data.vos.ProfileVO
import com.linhtetko.custom_view_assignment.delegate.AddTaskDelegate
import com.linhtetko.custom_view_assignment.delegate.ProfileItemDelegate
import com.linhtetko.custom_view_assignment.viewholders.TaskViewHolder

class TaskAdapter(
    private val profileItemDelegate: ProfileItemDelegate,
    private val addTaskDelegate: AddTaskDelegate
): RecyclerView.Adapter<TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_task, parent, false)
        return TaskViewHolder(view, profileItemDelegate, addTaskDelegate)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val list = (1..2).toList()
        val profiles = mutableListOf<ProfileVO>()

        list.forEachIndexed { index, i ->
            profiles.add(ProfileVO(type = ProfileListActionType.PROFILE))
        }
        holder.bindData(profiles)
    }

    override fun getItemCount(): Int = 10
}