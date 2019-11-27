package com.omarea.krscript.ui

import android.content.Context
import android.view.ViewGroup
import com.omarea.krscript.R
import com.omarea.krscript.model.GroupNode

class ListItemGroup(context: Context,
                    final var isRootGroup: Boolean,
                    config: GroupNode = GroupNode()) :
        ListItemView(
                context,
                if (isRootGroup) R.layout.kr_group_list_root else R.layout.kr_group_list_item,
                config) {
    protected var children = ArrayList<ListItemView>()

    fun addView(item: ListItemView): ListItemGroup {
        val content = layout.findViewById<ViewGroup>(android.R.id.content)
        content.addView(item.getView())

        children.add(item)

        return this
    }

    fun triggerActionByKey(key: String): Boolean {
        for (child in this.children) {
            if (child is ListItemClickable && child.key.equals(key)) {
                child.triggerAction()
                return true
            }
        }
        return false
    }

    fun triggerActionByIndex(index: String): Boolean {
        for (child in this.children) {
            if (child is ListItemClickable && child.index.equals(index)) {
                child.triggerAction()
                return true
            }
        }
        return false
    }

    init {
        title = config.separator
    }
}
