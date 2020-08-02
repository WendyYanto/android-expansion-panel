package dev.wendyyanto.expansionpanel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.wendy.library.PanelAdapter
import dev.wendyyanto.expansionpanel.databinding.ItemContentBinding

class DataAdapter(private val items: List<String>): PanelAdapter() {

    override fun getContentView(view: ViewGroup): RecyclerView.ViewHolder {
        val binding = ItemContentBinding.inflate(LayoutInflater.from(view.context), view, false)
        return ItemHolder(binding)
    }

    override fun bindContentView(holder: RecyclerView.ViewHolder, position: Int): View {
        val view = holder as ItemHolder
        view.bind(items[position])
        return view.itemView
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ItemHolder(private val binding: ItemContentBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.tvTitle.text = item
        }
    }
}