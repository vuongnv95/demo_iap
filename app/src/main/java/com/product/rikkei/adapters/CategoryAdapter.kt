package com.product.rikkei.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.product.rikkei.R
import com.product.rikkei.databinding.ItemCategoryBinding
import com.product.rikkei.utils.PremiumManager

class CategoryAdapter(private val onItemCategoryClickListener: OnItemCategoryClickListener) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    var categories: MutableList<String> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCategoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories[position]
        with(holder.binding) {
            tvName.text = category
            if (position < 6) {
                ivLock.setImageResource(R.drawable.circle_unlock)
            } else {
                if (PremiumManager.getInstance()?.isPremium == true) {
                    ivLock.setImageResource(R.drawable.circle_unlock)
                } else {
                    ivLock.setImageResource(R.drawable.circle_lock)
                }
            }
            root.setOnClickListener {
                onItemCategoryClickListener.onItemCategoryClick(position, category)
            }
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    interface OnItemCategoryClickListener {
        fun onItemCategoryClick(index: Int, category: String)
    }
}