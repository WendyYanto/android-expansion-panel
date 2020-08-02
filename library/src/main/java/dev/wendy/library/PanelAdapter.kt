package dev.wendy.library

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.wendy.library.databinding.ItemPanelBinding

abstract class PanelAdapter : RecyclerView.Adapter<PanelViewHolder>() {

    private val listener = mutableMapOf<Int, PanelListener>()

    private var isOpenSingleOnly = false

    abstract fun getContentView(view: ViewGroup): RecyclerView.ViewHolder

    abstract fun bindContentView(holder: RecyclerView.ViewHolder, position: Int): View

    open fun setupOpenSingleOnly(value: Boolean) {
        this.isOpenSingleOnly = value
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PanelViewHolder {
        return PanelViewHolder(
            ItemPanelBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            getContentView(parent),
            ::onClick
        )
    }

    override fun onBindViewHolder(holder: PanelViewHolder, position: Int) {
        val contentView = bindContentView(holder.getContentView(), position)
        val index = holder.adapterPosition
        if (listener[index] == null) {
            listener[index] = PanelListener()
        }
        listener[index]?.let { data ->
            holder.bind(contentView, index, data)
        }
    }

    private fun onClick(index: Int) {
        if (index == -1) return
        listener[index]?.toggleExpand()
        notifyItemChanged(index)
        if (isOpenSingleOnly) {
            listener.filter { item ->
                item.value.isExpand &&
                        item.key != index
            }.forEach { item ->
                item.value.isExpand = false
                notifyItemChanged(item.key)
            }
        }
    }
}