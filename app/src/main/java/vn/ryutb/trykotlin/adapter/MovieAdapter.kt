package vn.ryutb.trykotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.movie_list_item.view.*
import vn.ryutb.trykotlin.R
import vn.ryutb.trykotlin.model.Movie

/**
 * Created by MyPC on 16/09/2017.
 */
class MovieAdapter : BaseAdapter<Movie>() {

    override fun addFooter() {
        super.addFooter()
        mList.add(Movie("Footer"))
    }

    /**
     * Create ViewHolder
     */

    override fun createHeaderViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder? {
        return null
    }

    override fun createItemViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder? {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.movie_list_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun createFooterViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder? {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.movie_list_footer_item, parent, false)
        return FooterViewHolder(view)
    }

    /**
     * Bind ViewHolder
     */
    override fun bindFooterViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    override fun bindItemViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MovieViewHolder) {
            holder.bindView(getItem(position))
        }
    }

    override fun bindHeaderViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }


    /**
     * ViewHolder declaration
     */
    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(forMovie: Movie) {
            itemView.name.text = forMovie.title
        }
    }

    class FooterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}