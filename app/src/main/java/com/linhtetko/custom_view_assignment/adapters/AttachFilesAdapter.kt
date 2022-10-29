package com.linhtetko.custom_view_assignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.linhtetko.custom_view_assignment.R
import com.linhtetko.custom_view_assignment.viewholders.AttachFileViewHolder

class AttachFilesAdapter : RecyclerView.Adapter<AttachFileViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttachFileViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_attachment_file, parent, false)
        return AttachFileViewHolder(view)
    }

    override fun onBindViewHolder(holder: AttachFileViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 1
    }
}