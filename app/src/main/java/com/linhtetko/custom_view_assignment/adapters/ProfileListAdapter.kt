package com.linhtetko.custom_view_assignment.adapters

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.linhtetko.custom_view_assignment.R
import com.linhtetko.custom_view_assignment.data.vos.ProfileVO
import com.linhtetko.custom_view_assignment.delegate.AddTaskDelegate
import com.linhtetko.custom_view_assignment.delegate.ProfileItemDelegate
import com.linhtetko.custom_view_assignment.viewholders.ProfileListAddViewHolder
import com.linhtetko.custom_view_assignment.viewholders.ProfileListViewHolder

class ProfileListAdapter(
    private var list: List<ProfileVO>,
    private val profileItemDelegate: ProfileItemDelegate,
    private val addTaskDelegate: AddTaskDelegate
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ProfileListActionType.ADD.ordinal -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_holder_add, parent, false)
                ProfileListAddViewHolder(view, addTaskDelegate)
            }
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.viewholder_profile, parent, false)
                ProfileListViewHolder(view, profileItemDelegate)
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        return when (list[position].type) {
            ProfileListActionType.ADD -> ProfileListActionType.ADD.ordinal
            ProfileListActionType.PROFILE -> ProfileListActionType.PROFILE.ordinal
            else -> ProfileListActionType.PROFILE.ordinal
        }
    }

    fun setItems(items: List<ProfileVO>) {
        list = items
        notifyDataSetChanged()
    }
}

enum class ProfileListActionType {
    PROFILE,
    ADD
}

class ProfileItemDecoration : ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        return outRect.set(0, 0, -40, 0)
    }
}