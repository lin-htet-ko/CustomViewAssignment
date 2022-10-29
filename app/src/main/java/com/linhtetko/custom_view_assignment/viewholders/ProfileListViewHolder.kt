package com.linhtetko.custom_view_assignment.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.linhtetko.custom_view_assignment.delegate.ProfileItemDelegate
import kotlinx.android.synthetic.main.viewholder_profile.view.*

class ProfileListViewHolder(itemView: View, profileItemDelegate: ProfileItemDelegate) : RecyclerView.ViewHolder(itemView) {


    init {
        itemView.imgVhProfile.setOnClickListener {
            profileItemDelegate.onTapProfile()
        }
    }
}