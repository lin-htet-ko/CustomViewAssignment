package com.linhtetko.custom_view_assignment.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.linhtetko.custom_view_assignment.data.vos.CategoryVO
import kotlinx.android.synthetic.main.viewholder_category_selected.view.*

class CategorySelectedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindData(item: CategoryVO){
        itemView.btnCategorySelected.text = item.name
    }
}