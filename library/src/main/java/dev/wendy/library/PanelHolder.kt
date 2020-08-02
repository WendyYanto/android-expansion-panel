package dev.wendy.library

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import dev.wendy.library.databinding.ItemPanelBinding

class PanelViewHolder(
    private val binding: ItemPanelBinding,
    private val contentView: RecyclerView.ViewHolder
) :
    RecyclerView.ViewHolder(binding.root) {

    private var isExpand = false

    fun getContentView(): RecyclerView.ViewHolder {
        return this.contentView
    }

    fun bind(contentView: View) {
        with(binding) {
            if (contentView.parent != null) {
                llContent.removeView(contentView)
            }
            llContent.addView(contentView)
            root.setOnClickListener {
                toggleVisibility()
            }
        }
        invalidateVisibility()
    }

    private fun toggleVisibility() {
        isExpand = !isExpand
        invalidateVisibility()
    }

    private fun invalidateVisibility() {
        if (isExpand) {
            binding.ivToggle.rotation = 0f
            binding.llContent.visibility = View.VISIBLE
        } else {
            binding.ivToggle.rotation = -90f
            binding.llContent.visibility = View.GONE
        }
    }

}