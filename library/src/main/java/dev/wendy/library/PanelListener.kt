package dev.wendy.library

data class PanelListener(var isExpand: Boolean = false) {
    fun toggleExpand() {
        this.isExpand = !this.isExpand
    }
}