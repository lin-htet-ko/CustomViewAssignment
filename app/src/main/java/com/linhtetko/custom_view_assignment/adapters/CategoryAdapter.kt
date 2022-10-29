package com.linhtetko.custom_view_assignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.linhtetko.custom_view_assignment.R
import com.linhtetko.custom_view_assignment.data.vos.CategoryVO
import com.linhtetko.custom_view_assignment.viewholders.CategorySelectedViewHolder
import com.linhtetko.custom_view_assignment.viewholders.CategoryUnselectedViewHolder

class CategoryAdapter(
    private var categories: List<CategoryVO>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        const val CATEGORY_SELECTED = 0
        const val CATEGORY_UNSELECTED = 1
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when(viewType){
            CATEGORY_SELECTED -> {
                val view = layoutInflater.inflate(R.layout.viewholder_category_selected, parent, false)
                CategorySelectedViewHolder(view)
            }
            else -> {
                val view = layoutInflater.inflate(R.layout.viewholder_category_unselected, parent, false)
                CategoryUnselectedViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)){
            CATEGORY_SELECTED -> {
                val viewHolder = holder as CategorySelectedViewHolder
                viewHolder.bindData(categories[position])
            }
            CATEGORY_UNSELECTED -> {
                val viewHolder = holder as CategoryUnselectedViewHolder
                viewHolder.bindData(categories[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun getItemViewType(position: Int): Int {
        return categories[position].type
    }

    fun setItems(items: List<CategoryVO>){
        categories = items
        notifyDataSetChanged()
    }
}