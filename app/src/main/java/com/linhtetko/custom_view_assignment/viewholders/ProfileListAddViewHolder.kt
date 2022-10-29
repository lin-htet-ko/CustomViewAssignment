package com.linhtetko.custom_view_assignment.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.linhtetko.custom_view_assignment.delegate.AddTaskDelegate
import kotlinx.android.synthetic.main.view_holder_add.view.*

class ProfileListAddViewHolder(itemView: View, addTaskDelegate: AddTaskDelegate) : RecyclerView.ViewHolder(itemView) {
    init {
        itemView.btnVhAdd.setOnClickListener {
            addTaskDelegate.onTapAdd()
        }

    }
}