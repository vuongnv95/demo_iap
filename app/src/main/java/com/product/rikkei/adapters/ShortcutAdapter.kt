package com.product.rikkei.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.product.rikkei.databinding.ItemShortcutBinding
import com.product.rikkei.models.Shortcut

class ShortcutAdapter() : RecyclerView.Adapter<ShortcutAdapter.ViewHolder>() {
    var shortcuts: MutableList<Shortcut> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ViewHolder(val binding: ItemShortcutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemShortcutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shortcut = shortcuts[position]
        with(holder.binding) {
            tvKey.text = shortcut.key
            tvUses.text = shortcut.uses
        }
    }

    override fun getItemCount(): Int {
        return shortcuts.size
    }

}