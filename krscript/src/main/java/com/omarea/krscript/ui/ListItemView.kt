package com.omarea.krscript.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.omarea.krscript.R
import com.omarea.krscript.model.ActionNode
import com.omarea.krscript.model.NodeInfoBase

open class ListItemView(private val context: Context,
                        private val layoutId: Int,
                        private val config: NodeInfoBase = NodeInfoBase()) {
    protected var layout = LayoutInflater.from(context).inflate(layoutId, null)

    protected var descView = layout.findViewById<TextView?>(R.id.kr_desc)
    protected var summaryView = layout.findViewById<TextView?>(R.id.kr_summary)
    protected var titleView = layout.findViewById<TextView?>(R.id.kr_title)

    var title: String
        get() {
            return titleView?.text.toString()
        }
        set(value) {
            if (value.isEmpty()) {
                titleView?.visibility = View.GONE
            } else {
                titleView?.text = value
                titleView?.visibility = View.VISIBLE
            }
        }

    var desc: String
        get() {
            return descView?.text.toString()
        }
        set(value) {
            if (value.isEmpty()) {
                descView?.visibility = View.GONE
            } else {
                descView?.text = value
                descView?.visibility = View.VISIBLE
            }
        }

    var summary: String
        get() {
            return summaryView?.text.toString()
        }
        set(value) {
            if (value.isEmpty()) {
                summaryView?.visibility = View.GONE
            } else {
                summaryView?.text = value
                summaryView?.visibility = View.VISIBLE
            }
        }

    val index: String
        get() {
            return config.index
        }

    fun getView(): View {
        return layout
    }

    init {
        title = config.title
        desc = config.desc
        summary = config.summary
    }
}
