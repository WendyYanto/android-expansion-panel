package dev.wendy.library

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.wendy.library.databinding.ItemPanelBinding


abstract class PanelAdapter : RecyclerView.Adapter<PanelViewHolder>() {

    abstract fun getContentView(view: ViewGroup): RecyclerView.ViewHolder

    abstract fun bindContentView(holder: RecyclerView.ViewHolder, position: Int): View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PanelViewHolder {
        return PanelViewHolder(
            ItemPanelBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            getContentView(parent)
        )
    }

    override fun onBindViewHolder(holder: PanelViewHolder, position: Int) {
        val contentView = bindContentView(holder.getContentView(), position)
        holder.bind(contentView)
    }
}