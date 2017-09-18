package vn.ryutb.trykotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by MyPC on 17/09/2017.
 */
abstract class BaseAdapter<I> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val VIEW_TYPE_HEADER = 0
    private val VIEW_TYPE_FOOTER = 1
    private val VIEW_TYPE_ITEM = 2

    private var isFooterAdded = false
    //List of Adapter
    protected var mList = ArrayList<I>()

    override fun getItemViewType(position: Int): Int {
        return if (isLastPosition(position) && isFooterAdded) VIEW_TYPE_FOOTER else VIEW_TYPE_ITEM
    }

    fun isLastPosition(position: Int): Boolean {
        return position == mList.size - 1
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        var viewHolder: RecyclerView.ViewHolder? = null
        when (viewType) {
            VIEW_TYPE_HEADER -> viewHolder = createHeaderViewHolder(parent)
            VIEW_TYPE_ITEM -> viewHolder = createItemViewHolder(parent)
            VIEW_TYPE_FOOTER -> viewHolder = createFooterViewHolder(parent)
            else -> {

            }
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun getItem(atPostion: Int): I {
        return mList[atPostion]
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            VIEW_TYPE_HEADER -> bindHeaderViewHolder(holder, position)
            VIEW_TYPE_ITEM -> bindItemViewHolder(holder, position)
            VIEW_TYPE_FOOTER -> bindFooterViewHolder(holder, position)
            else -> {

            }
        }
    }

    fun newList(withList: List<I>) {
        mList.clear()
        mList.addAll(withList)
        notifyDataSetChanged()
    }

    fun addList(addedList: List<I>) {
        mList.addAll(addedList)
        notifyDataSetChanged()
    }

    open fun addFooter() {
        isFooterAdded = true
    }
    abstract fun bindFooterViewHolder(holder: RecyclerView.ViewHolder, position: Int)

    abstract fun bindItemViewHolder(holder: RecyclerView.ViewHolder, position: Int)

    abstract fun bindHeaderViewHolder(holder: RecyclerView.ViewHolder, position: Int)

    abstract fun createHeaderViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder?

    abstract fun createItemViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder?

    abstract fun createFooterViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder?
}