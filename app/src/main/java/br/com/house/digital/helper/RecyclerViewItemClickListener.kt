package br.com.house.digital.helper

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewItemClickListener(
    context: Context?,
    recyclerView: RecyclerView,
    private val _listener: OnItemClickListener?
) :
    RecyclerView.OnItemTouchListener {

    var _gestureDetector: GestureDetector

    init {
        _gestureDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
            override fun onSingleTapUp(e: MotionEvent): Boolean {
                return true
            }

            override fun onLongPress(e: MotionEvent) {
                val child = recyclerView.findChildViewUnder(e.x, e.y)
                if (child != null && _listener != null) {
                    _listener.onLongItemClick(child, recyclerView.getChildAdapterPosition(child))
                }
            }
        })
    }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        val childView = rv.findChildViewUnder(e.x, e.y)
        if (childView != null && _listener != null && _gestureDetector.onTouchEvent(e)) {
            _listener.onItemClick(childView, rv.getChildAdapterPosition(childView))
            return true
        }
        return false
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {}

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}

    interface OnItemClickListener : AdapterView.OnItemClickListener {
        fun onItemClick(view: View?, position: Int)
        fun onLongItemClick(view: View?, position: Int)
    }
}