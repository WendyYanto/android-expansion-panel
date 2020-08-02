package dev.wendy.library

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import dev.wendy.library.databinding.ItemPanelBinding

class PanelViewHolder(
    private val binding: ItemPanelBinding,
    private val contentView: RecyclerView.ViewHolder,
    private val onClickListener: (index: Int) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    fun getContentView(): RecyclerView.ViewHolder {
        return this.contentView
    }

    fun bind(contentView: View, index: Int, listener: PanelListener) {
        with(binding) {
            if (contentView.parent != null) {
                llContent.removeView(contentView)
            }
            llContent.addView(contentView)
            root.setOnClickListener {
                onClickListener.invoke(index)
            }
        }
        invalidateVisibility(listener)
    }

    private fun invalidateVisibility(listener: PanelListener) {
        with(listener) {
            if (isExpand) {
                binding.ivToggle.rotation = 0f
                binding.llContent.visibility = View.VISIBLE
            } else {
                binding.ivToggle.rotation = -90f
                binding.llContent.visibility = View.GONE
            }
        }
    }

}